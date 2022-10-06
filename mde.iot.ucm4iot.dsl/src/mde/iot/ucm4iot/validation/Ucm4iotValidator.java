/*
 * generated by Xtext 2.25.0
 */
package mde.iot.ucm4iot.validation;

import java.util.*;
import java.util.stream.*;
import org.eclipse.emf.common.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.*;

import mde.iot.ucm4iot.Ucm4iotUtilities;
import mde.iot.ucm4iot.ucm4iot.*;
import mde.iot.ucm4iot.ucm4iot.Exception;

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class Ucm4iotValidator extends AbstractUcm4iotValidator {
	public static final String MAIN_STEP_REGEX = "[1-9]\\d*(\\.[1-9]\\d*)*";
	public static final String EXTENSION_STEP_REXGEX = "([1-9]\\d*|\\([1-9]\\d*-[1-9]\\d*\\))[a-zA-Z]+(\\.[1-9]\\d*([a-zA-Z]+)?)*";

	/*
	 * checkMainScenarioStepNumberGrammar(..)
	 * --------------------------------------
	 * Checks the grammar of the step numbers in the main scenario.
	 */
	@Check
	public void checkMainScenarioStepNumberGrammar(MainScenario mainScenario) {
		// List all numbered steps that don't conform to the regex for main steps.
		List<Step> incorrectSteps = mainScenario.getSteps().stream()
				.filter(step ->  Ucm4iotUtilities.hasStepNumber(step))
				.filter(step -> !Ucm4iotUtilities.getStepNumber(step).matches(MAIN_STEP_REGEX))
				.collect(Collectors.toList());
		
		// Show error message for both types of numbered steps.
		String errorMessage = "'%s' is not a valid step number for a step in a main success scenario clause.";
		
		incorrectSteps.stream()
				.filter(step -> step instanceof InteractionStep)
				.forEach(step -> errorFormat(errorMessage, step, Ucm4iotPackage.Literals.INTERACTION_STEP__STEP_NUMBER, "issue", Ucm4iotUtilities.getStepNumber(step)));
		
		incorrectSteps.stream()
				.filter(step -> step instanceof InvocationStep)
				.forEach(step -> errorFormat(errorMessage, step, Ucm4iotPackage.Literals.INVOCATION_STEP__STEP_NUMBER,  "issue", Ucm4iotUtilities.getStepNumber(step)));
	}
	
	/*
	 * checkExtensionBlockStepNumberGrammar(..)
	 * ----------------------------------------
	 * Checks the grammar of each numbered step in an extension block.
	 */
	@Check
	public void checkExtensionBlockStepNumberGrammar(ExtensionBlock block) {
		// List all numbered steps that don't conform to the regex for extension steps.
		List<Step> incorrectSteps = block.getSteps().stream()
				.filter(step ->  Ucm4iotUtilities.hasStepNumber(step))
				.filter(step -> !Ucm4iotUtilities.getStepNumber(step).matches(EXTENSION_STEP_REXGEX))
				.collect(Collectors.toList());
		
		// Show error message for both types of numbered steps.
		String errorMessage = "'%s' is not a valid step number for a step in an extension block clause.";
		
		incorrectSteps.stream()
				.filter(step -> step instanceof InteractionStep)
				.forEach(step -> errorFormat(errorMessage, step, Ucm4iotPackage.Literals.INTERACTION_STEP__STEP_NUMBER, "issue", Ucm4iotUtilities.getStepNumber(step)));
		
		incorrectSteps.stream()
				.filter(step -> step instanceof InvocationStep)
				.forEach(step -> errorFormat(errorMessage, step, Ucm4iotPackage.Literals.INVOCATION_STEP__STEP_NUMBER,  "issue", Ucm4iotUtilities.getStepNumber(step)));
	}
	
	/*
	 * checkMainScenarioStepNumberOrdering(..)
	 * ---------------------------------------
	 * Checks the ordering of steps in the main scenario.
	 */
	@Check
	public void checkMainScenarioStepNumberOrdering(MainScenario mainScenario) {
		HashMap<Step, String> incorrectSteps = new HashMap<>();
		
		// Exclusively check the ordering of numbered steps.
		List<Step> steps = mainScenario.getSteps().stream()
				.filter(step -> Ucm4iotUtilities.hasStepNumber(step))
				.filter(step -> Ucm4iotUtilities.getStepNumber(step).matches(MAIN_STEP_REGEX))
				.collect(Collectors.toList());
		
		// Determines if the steps are ordered correctly in the main scenario.
		ArrayList<String> expectedStepNumbers = getMainScenarioNextExpectedStepNumbers(null);
		
		for (Step step : steps) {
			String currentStepNumber = Ucm4iotUtilities.getStepNumber(step);
			
			// If current step number is not an expected step number.
			if (!expectedStepNumbers.contains(currentStepNumber)) {
				String expectedStepNumbersMessage = expectedStepNumbers.stream()
						.collect(Collectors.joining(", "));
				
				incorrectSteps.put(step, expectedStepNumbersMessage);
			}
			
			expectedStepNumbers = getMainScenarioNextExpectedStepNumbers(currentStepNumber);
		}
		
		// Show error message for both types of numbered steps.
		String errorMessage = "'%s' unexpected in main success scenario. Expecting steps numbers: [%s].";

		incorrectSteps.entrySet().stream()
				.filter(entry -> entry.getKey() instanceof InteractionStep)
				.forEach(entry -> errorFormat(errorMessage, entry.getKey(), Ucm4iotPackage.Literals.INTERACTION_STEP__STEP_NUMBER, "issue", Ucm4iotUtilities.getStepNumber(entry.getKey()), entry.getValue()));

		incorrectSteps.entrySet().stream()
				.filter(entry -> entry.getKey() instanceof InvocationStep)
				.forEach(entry -> errorFormat(errorMessage, entry.getKey(), Ucm4iotPackage.Literals.INVOCATION_STEP__STEP_NUMBER,  "issue", Ucm4iotUtilities.getStepNumber(entry.getKey()), entry.getValue()));
	}
	
	/*
	 * checkExtensionBlockStepNumbers(..)
	 * ----------------------------------
	 * Checks the step numbers of all extension blocks.
	 */
	@Check
	public void checkExtensionBlockStepNumbers(Extensions extensions) {
		List<ExtensionBlock> extensionBlocks = extensions.getBlocks();
		
		// Determines the expected ordering of the blocks.
		List<ExtensionBlock> expectedOrdering = extensions.getBlocks().stream()
				.sorted((b1, b2) -> Ucm4iotUtilities.getStepNumber(b1.getRefStep()).compareTo(Ucm4iotUtilities.getStepNumber(b2.getRefStep())))
				.collect(Collectors.toList());
		
		// Compares the actual ordering of blocks with the expected ordering.
		for (int i = 0; i < extensionBlocks.size(); i++) {
			ExtensionBlock block = extensionBlocks.get(i);
			ExtensionBlock expected = expectedOrdering.get(i);
			
			if (block.getRefStep() != expected.getRefStep()) {
				String errorMessage = "'%s' unexpected in extensions. Expecting extension block for step: '%s' to appear first.";
				errorFormat(errorMessage, block, Ucm4iotPackage.eINSTANCE.eContainmentFeature(), "issue", Ucm4iotUtilities.getStepNumber(block.getRefStep()), Ucm4iotUtilities.getStepNumber(expected.getRefStep()));
				return;
			}
		}
		
		// Groups each group of extension blocks based on their referenced step.
		Map<Step, List<ExtensionBlock>> groups = extensionBlocks.stream()
				.collect(Collectors.groupingBy(block -> block.getRefStep()));
		
		// Validate the step numbers of each block.
		groups.entrySet().stream();
		for (Step key : groups.keySet()) {
			List<ExtensionBlock> blockSet = groups.get(key);
			
			// Determine the label for each step in a block.
			for (int i = 0; i < blockSet.size(); i++) {
				ExtensionBlock block = blockSet.get(i);
				String label = getLabel(i+1);
				checkExtensionBlockStepNumbersHelper(block, label);
			}
		}
	}
	
	/*
	 * checkExtensionBlockStepNumbersHelper(..)
	 * ----------------------------------------
	 * Helper function for the checkExtensionBlockStepNumbers(..) function. 
	 */
	private void checkExtensionBlockStepNumbersHelper(ExtensionBlock block, String expectedContext) {
		HashMap<Step, String> incorrectSteps = new HashMap<>();

		// Exclusively check the ordering of numbered steps.
		List<Step> steps = block.getSteps().stream()
				.filter(step -> Ucm4iotUtilities.hasStepNumber(step))
				.filter(step -> Ucm4iotUtilities.getStepNumber(step).matches(EXTENSION_STEP_REXGEX))
				.collect(Collectors.toList());
		
		// Generate the first expected step.
		String context = "";
		if (block.isHasRangedRef()) {
			context = "(" + Ucm4iotUtilities.getStepNumber(block.getRefStep()) + "-" + Ucm4iotUtilities.getStepNumber(block.getEndRefStep()) + ")" + expectedContext;
		} else {
			context = Ucm4iotUtilities.getStepNumber(block.getRefStep()) + expectedContext;
		}
		
		ArrayList<String> expectedStepNumbers = getExtensionBlockNextExpectedStepNumbers(context, null);
		for (Step step : steps) {
			String currentStepNumber = Ucm4iotUtilities.getStepNumber(step);
			
			// If current step number is not an expected step number.
			if (!expectedStepNumbers.contains(currentStepNumber)) {
				String expectedStepNumbersMessage = expectedStepNumbers.stream()
						.collect(Collectors.joining(", "));
				
				incorrectSteps.put(step, expectedStepNumbersMessage);
			}
			
			expectedStepNumbers = getExtensionBlockNextExpectedStepNumbers(context, currentStepNumber);
		}
		
		String errorMessage = "'%s' unexpected in extension block. Expecting steps numbers: [%s].";

		incorrectSteps.entrySet().stream()
				.filter(entry -> entry.getKey() instanceof InteractionStep)
				.forEach(entry -> errorFormat(errorMessage, entry.getKey(), Ucm4iotPackage.Literals.INTERACTION_STEP__STEP_NUMBER, "issue", Ucm4iotUtilities.getStepNumber(entry.getKey()), entry.getValue()));

		incorrectSteps.entrySet().stream()
				.filter(entry -> entry.getKey() instanceof InvocationStep)
				.forEach(entry -> errorFormat(errorMessage, entry.getKey(), Ucm4iotPackage.Literals.INVOCATION_STEP__STEP_NUMBER,  "issue", Ucm4iotUtilities.getStepNumber(entry.getKey()), entry.getValue()));		
	}
	
	/*
	 * checkUseCaseExtensionBlockReferencedStepExists(..)
	 * --------------------------------------------------
	 * Checks if the referenced step of an extension block exists in either the main scenario or a parent block.
	 */
	@Check
	public void checkUseCaseExtensionBlockReferencedStepExists(UseCase useCase) {
		Extensions extensions = useCase.getExtensions();
		
		// Get the step numbers in the main scenario.
		List<String> mainStepNumbers = useCase.getMain().getSteps().stream()
				.filter(step -> Ucm4iotUtilities.hasStepNumber(step))
				.map(step -> Ucm4iotUtilities.getStepNumber(step))
				.collect(Collectors.toList());
		
		// Recursively check each extension block in the extensions.
		extensions.getBlocks().stream()
				.forEach(block -> checkUseCaseExtensionBlockReferencedStepExistsHelper(mainStepNumbers, block, "main success scenario"));
	}
	
	/*
	 * checkUseCaseExtensionBlockReferencedStepExistsHelper(..)
	 * --------------------------------------------------------
	 * Helper function. Recursively searches extension blocks.
	 */
	private void checkUseCaseExtensionBlockReferencedStepExistsHelper(List<String> contextStepNumbers, ExtensionBlock block, String contextDescription) {
		String refStep = Ucm4iotUtilities.getStepNumber(block.getRefStep());
		
		// Show error message when the referenced step is not found.
		String errorMessage = "'%s' not found in %s.";
		
		if (!contextStepNumbers.contains(refStep)) {
			errorFormat(errorMessage, block, Ucm4iotPackage.Literals.EXTENSION_BLOCK__REF_STEP, "issue", refStep, contextDescription);
		}
		
		// Get the step numbers in this block.
		List<String> blockStepNumbers = block.getSteps().stream()
				.filter(step -> Ucm4iotUtilities.hasStepNumber(step))
				.map(step -> Ucm4iotUtilities.getStepNumber(step))
				.collect(Collectors.toList());
		
		// Recursively check each extension block in the extensions.
		List<ExtensionBlock> blocks = block.getBlocks();
		
		if (blocks != null) {
			blocks.stream()
					.forEach(innerBlock -> checkUseCaseExtensionBlockReferencedStepExistsHelper(blockStepNumbers, innerBlock, "parent block"));
		}
	}
	
	/*
	 * checkUseCaseInteractionStepsContainActorAndSystem(..)
	 * -----------------------------------------------------
	 * Checks if interaction steps within a use case contain an actor and the system.
	 */
	@Check
	public void checkUseCaseInteractionStepsContainActorAndSystem(UseCase useCase) {
		Level level = useCase.getLevel();
		if (level != null && level.equals(Level.SUBFUNCTION)) {
			return;
		}
		
		// Find all actors.
		List<String> actorNames = getActors(useCase).stream()
				.map(actor -> getActorName(actor))
				.collect(Collectors.toList());
		
		// List aliases that refer to the system.
		List<String> systemAliases = Stream.of("System", "system")
				.collect(Collectors.toList());
		
		// Show error message for steps that don't contain an actor or the system
		String errorMessage = "Step '%s' defined as interaction step, but missing the system or an actor.";
		
		// Checks all steps in the main success scenario.
		MainScenario main = useCase.getMain();
		if (main != null) {
			main.getSteps().stream()
					.filter(step -> !step.isIgnoreDescription())
					.filter(step -> step instanceof InteractionStep)
					.filter(step -> !(hasAnyWords(step, actorNames) && hasAnyWords(step, systemAliases)))
					.forEach(step -> errorFormat(errorMessage, step, Ucm4iotPackage.eINSTANCE.eContainmentFeature(), "issue", Ucm4iotUtilities.getStepNumber(step)));
		}
		
		// Checks all steps in the extensions.
		Extensions extensions = useCase.getExtensions();
		if (extensions != null) {
			extensions.getBlocks().stream()
					.map(block -> block.getSteps())
					.flatMap(List::stream)
					.filter(step -> !step.isIgnoreDescription())
					.filter(step -> step instanceof InteractionStep)
					.filter(step -> !Ucm4iotUtilities.hasStepException(step))
					.filter(step -> !(hasAnyWords(step, actorNames) && hasAnyWords(step, systemAliases)))
					.forEach(step -> errorFormat(errorMessage, step, Ucm4iotPackage.eINSTANCE.eContainmentFeature(), "issue", Ucm4iotUtilities.getStepNumber(step)));
		}
	}
	
	/*
	 * checkUseCaseActorsAreInInteractionSteps(..)
	 * -------------------------------------------
	 * Checks if the actors in a use case are referenced in any interaction steps.
	 */
	@Check
	public void checkUseCaseActorsAreInInteractionSteps(UseCase useCase) {
		String warningMessage = "Actor '%s' is not used anywhere in use case: '%s'.";
		
		// Checks each actor.
		for (Actor actor : getActors(useCase)) {
			String name = getActorName(actor);
			boolean actorUsedInMain = false;
			boolean actorUsedInExtensions = false;
			
			// Check if the actor is referenced in the main scenario.
			MainScenario main = useCase.getMain();
			if (main != null) {
				actorUsedInMain = main.getSteps().stream()
						.filter(step -> !step.isIgnoreDescription())
						.anyMatch(step -> hasWord(step, name));
			}
			
			// Check if the actor is referenced in the extensions.
			Extensions extensions = useCase.getExtensions();
			if (extensions != null) {
				actorUsedInExtensions = extensions.getBlocks().stream()
						.map(block -> block.getSteps())
						.flatMap(List::stream)
						.filter(step -> !step.isIgnoreDescription())
						.anyMatch(step -> hasWord(step, name));
			}
			
			// If the actor is not referenced anywhere, then show warning message.
			if (!(actorUsedInMain || actorUsedInExtensions)) {
				warningFormat(warningMessage, actor, Ucm4iotPackage.eINSTANCE.eContainmentFeature(), "issue", name, useCase.getName());
			}
		}
	}
	
	/*
	 * checkExceptionalBlockExceptionHandlerExists(..)
	 * -----------------------------------------------
	 * Checks if a handler exists for a thrown exception. If the block continues to another step, then there is an error.
	 */
	@Check
	public void checkExceptionalBlockExceptionHandlerExists(ExceptionalBlock block) {
		List<Exception> exceptions = block.getSteps().stream()
				.filter(step -> step instanceof InteractionStep)
				.filter(step -> Ucm4iotUtilities.hasStepException(step))
				.map(step -> Ucm4iotUtilities.getStepException(step))
				.collect(Collectors.toList());
		
		// In case no exception is in the exceptional block yet.
		if (!exceptions.isEmpty()) {
			Exception exception = exceptions.get(0);
			
			// Finds all handlers.
			IoTUseCaseModel root = EcoreUtil2.getContainerOfType(exception, IoTUseCaseModel.class);
			List<HandlerUseCase> handlers = EcoreUtil2.getAllContentsOfType(root, HandlerUseCase.class).stream()
					.filter(handler -> handler.getContextExceptions().stream()
							.anyMatch(ce -> ce.getException().equals(exception)))
					.collect(Collectors.toList());
			
			// If there are no handlers and the outcome continues to another step.
			if (handlers.isEmpty() && block.getOutcome() instanceof OutcomeContinues) {
				OutcomeContinues outcome = (OutcomeContinues)block.getOutcome();
				
				String errorMessage = "Outcome cannot continue to step '%s'. There is no handler for exception '%s' and block interrupts and fails.";
				errorFormat(errorMessage, block, Ucm4iotPackage.Literals.EXTENSION_BLOCK__OUTCOME, "issue", Ucm4iotUtilities.getStepNumber(outcome.getStep()), exception.getName());
			}
		}
	}
	
	/*
	 * checkStandardModeActors(..)
	 * ---------------------------
	 * Checks if the exceptions in the standard mode are not typed.
	 */
	@Check
	public void checkStandardModeActors(UseCase useCase) {
		IoTUseCaseModel root = EcoreUtil2.getContainerOfType(useCase, IoTUseCaseModel.class);
		if (!root.isStandardMode()) {
			return;
		}
		
		String errorMessage = "Actor '%s' cannot be typed in standard mode.";
		
		// If in standard mode, check each actor.
		for (Actor actor : getActors(useCase)) {
			if (actor instanceof PhysicalEntityActor ||
				actor instanceof DeviceActor ||
				actor instanceof HumanActor ||
				actor instanceof SoftwareActor) {
				
				errorFormat(errorMessage, actor, Ucm4iotPackage.eINSTANCE.eContainmentFeature(), "issue", actor.getName());
				
			}
		}
		
		getActors(useCase);
	}
	
	/*
	 * checkIoTModeActors(..)
	 * ---------------------------
	 * Checks if the exceptions in the standard mode are not typed.
	 */
	@Check
	public void checkIoTModeActors(UseCase useCase) {
		IoTUseCaseModel root = EcoreUtil2.getContainerOfType(useCase, IoTUseCaseModel.class);
		if (root.isStandardMode()) {
			return;
		}
		
		String errorMessage = "Actor '%s' must be typed in ucm4iot mode.";
		
		// If not in standard mode, check each actor.
		for (Actor actor : getActors(useCase)) {
			if (!(actor instanceof PhysicalEntityActor ||
				  actor instanceof DeviceActor ||
				  actor instanceof HumanActor ||
				  actor instanceof SoftwareActor)) {
				
				errorFormat(errorMessage, actor, Ucm4iotPackage.eINSTANCE.eContainmentFeature(), "issue", actor.getName());
			}
		}
		
		getActors(useCase);
	}
	
	/*
	 * checkStandardModeExtensionBlocks(..)
	 * ------------------------------------
	 * Check that there is no exception blocks in standard mode.
	 */
	@Check
	public void checkStandardModeExtensionBlocks(Extensions extensions) {
		IoTUseCaseModel root = EcoreUtil2.getContainerOfType(extensions, IoTUseCaseModel.class);
		if (!root.isStandardMode()) {
			return;
		}
		
		// Check for any exception blocks in standard mode.
		String errorMessage = "Exception blocks cannot appear in standard mode.";
		for (ExtensionBlock block : extensions.getBlocks()) {
			if (block instanceof ExceptionalBlock) {
				errorFormat(errorMessage, block, Ucm4iotPackage.eINSTANCE.eContainmentFeature(), "issue");
			}
		}
		
		
	}
	
	/*
	 * checkHandlerUseCaseExceptionExists(..)
	 * --------------------------------------
	 * Checks if the exceptions in the context exception clause of the handler use cases exist in another use case.
	 */
	@Check
	public void checkHandlerUseCaseExceptionExists() {
		// TODO: implement.
	}
	
	/*
	 * checkUseCaseExceptionHandled(..)
	 * --------------------------------
	 * Checks if exceptions declared in a use case are referenced in a handler use case.
	 */
	@Check
	public void checkUseCaseExceptionHandled() {
		// TODO: implement.
	}
	
	/*
	 * checkMainScenarioExceptionFree(..)
	 * ----------------------------------
	 * Checks that the main scenario doesn't declare any exceptions.
	 */
	@Check
	public void checkMainScenarioExceptionFree(MainScenario main) {
		String errorMessage = "Step '%s' cannot have exception '%s', as it is in the main success scenario.";
		
		// Show error message for any step that contains an exception.
		main.getSteps().stream()
				.filter(step -> Ucm4iotUtilities.hasStepException(step))
				.forEach(step -> errorFormat(errorMessage, step, Ucm4iotPackage.Literals.INTERACTION_STEP__EXCEPTION, "issue", Ucm4iotUtilities.getStepNumber(step), Ucm4iotUtilities.getStepException(step).getName()));
	}
	
	/*
	 * checkAlternativeBlockExceptionFree(..)
	 * --------------------------------------
	 * Checks that alternative blocks don't declare any exceptions.
	 */
	@Check
	public void checkAlternativeBlockExceptionFree(AlternateBlock block) {
		String errorMessage = "Step '%s' cannot have exception '%s', as it is in an alternative block.";
		
		// Show error message for any step that contains an exception.
		block.getSteps().stream()
				.filter(step -> Ucm4iotUtilities.hasStepException(step))
				.forEach(step -> errorFormat(errorMessage, step, Ucm4iotPackage.Literals.INTERACTION_STEP__EXCEPTION, "issue", Ucm4iotUtilities.getStepNumber(step), Ucm4iotUtilities.getStepException(step).getName()));
	}
	
	/*
	 * checkExceptionalBlockContainsException(..)
	 * ------------------------------------------
	 * Checks that exceptional blocks declare an exception.
	 */
	@Check
	public void checkExceptionalBlockContainsException(ExceptionalBlock block) {
		String warningMessage = "Exceptional block missing exception.";
		
		boolean hasException = block.getSteps().stream()
				.anyMatch(step -> Ucm4iotUtilities.hasStepException(step));
		
		// Show warning message if the exceptional block contains no exceptions.
		if (!hasException) {
			warningFormat(warningMessage, block, Ucm4iotPackage.eINSTANCE.eContainmentFeature(), "issue");
		}
	}
	
	/*
	 * checkExceptionalBlockContainsOneException(..)
	 * ---------------------------------------------
	 * Checks that exceptional blocks only declare one exception.
	 */
	@Check
	public void checkExceptionalBlockContainsOneException(ExceptionalBlock block) {
		String errorMessage = "Exceptional block can only throw one exception.";
		
		List<Step> steps = block.getSteps().stream()
				.filter(step -> Ucm4iotUtilities.hasStepException(step))
				.collect(Collectors.toList());
		
		// Show error message for every exception declared after the first exception.
		for (int i = 1; i < steps.size(); i++) {
			Exception exception = Ucm4iotUtilities.getStepException(steps.get(i));
			errorFormat(errorMessage, exception, Ucm4iotPackage.eINSTANCE.eContainmentFeature(), "issue");
		}
	}
	
	/*
	 * hasWords(..)
	 * ------------
	 * Returns true if a step has any of the passed words; false otherwise.
	 */
	private boolean hasAnyWords(Step step, List<String> words) {
		return words.stream()
				.anyMatch(word -> hasWord(step, word));
	}
	
	/*
	 * hasWord(..)
	 * -----------
	 * Returns true if a step has the passed word; false otherwise.
	 */
	private boolean hasWord(Step step, String value) {
		String description = "";
		if (step.isIgnoreDescription()) {
			description = "";
		} else {
			description = step.getDescription();
		}
		
		String[] words = description
				.replaceAll("[^a-zA-Z0-9]", " ")
				.split("\\s+");
		
		// Check if any words match the passed String.
		for (String word : words) {
			if (value.equals(word)) {
				return true;
			}
		}
		
		return false;
	}
	
	/*
	 * getActors(..)
	 * -------------
	 * Get the actors of a use case.
	 */
	private ArrayList<Actor> getActors(UseCase useCase) {
		ArrayList<Actor> actors = new ArrayList<>();
		
		// Adds the primary actor to the list.
		Actor primaryActor = useCase.getPrimaryActor();
		if (primaryActor != null) {
			actors.add(primaryActor);
		}
		
		// Adds the secondary actors to the list.
		EList<SecondaryActor> secondaryActors = useCase.getSecondaryActors();
		if (secondaryActors != null) {
			actors.addAll(secondaryActors);
		}
		
		// Adds the facilitator actors to the list.
		EList<SecondaryActor> facilitatorActors = useCase.getFacilitatorActors();
		if (facilitatorActors != null) {
			actors.addAll(facilitatorActors);
		}
		
		return actors;
	}
	
	/*
	 * getActorName(..)
	 * ----------------
	 * Gets the name of an actor.
	 */
	private String getActorName(Actor actor) {
		return actor.getName();
		/*if (actor instanceof PhysicalEntityActor) {
			return ((PhysicalEntityActor)actor).getName();
		} else if (actor instanceof DeviceActor) {
			return ((DeviceActor)actor).getName();
		} else if (actor instanceof SoftwareActor) {
			return ((SoftwareActor)actor).getName();
		} else {
			return ((HumanActor)actor).getName();
		}*/
	}
	
	/*
	 * getLabel(..)
	 * -------------
	 * Gets a label based on an integer. (i.e. 1='a', 2='b', ..., 26='z', 27='aa', etc.)
	 */
	private String getLabel(int number) {
        StringBuilder sb = new StringBuilder();
        while (number-- > 0) {
            sb.append((char)('a' + (number % 26)));
            number /= 26;
        }
        return sb.reverse().toString();
    }
	
	/*
	 * getMainScenarioNextExpectedStepNumbers(..)
	 * ------------------------------------------
	 * Gets the next expected step numbers of a given step.
	 */
	private ArrayList<String> getMainScenarioNextExpectedStepNumbers(String currentStepNumber) {
		ArrayList<String> expectedStepNumbers = new ArrayList<>();
		
		// Creates a list of possible step numbers that can occur after the current step number.
		if (currentStepNumber == null || currentStepNumber.trim().isEmpty()) {
			expectedStepNumbers.add("1");
		} else {
			List<Integer> arr = Arrays.asList(currentStepNumber.split("\\.")).stream()
					.map(g -> Integer.parseInt(g))
					.collect(Collectors.toList());
			
			// Build a possible sub-step.
			String possibleStep = arr.stream()
					.map(String::valueOf)
					.collect(Collectors.joining(".")) + ".1";
			expectedStepNumbers.add(possibleStep);
			
			// Build all possible steps.
			for (int i = arr.size() - 1; i >= 0; i--) {
				arr.set(i, arr.get(i) + 1);
				
				possibleStep = arr.stream()
						.map(String::valueOf)
						.collect(Collectors.joining("."));
				
				expectedStepNumbers.add(possibleStep);
				arr.remove(i);
			}
		}
		
		return expectedStepNumbers;
	}
	
	/*
	 * getExtensionBlockNextExpectedStepNumbers(..)
	 * --------------------------------------------
	 * Gets the next expected step numbers of a given step.
	 */
	private ArrayList<String> getExtensionBlockNextExpectedStepNumbers(String context, String currentStepNumber) {
		ArrayList<String> expectedStepNumbers = new ArrayList<>();

		// Creates a list of possible step numbers that can occur after the current step number.
		if (currentStepNumber == null || currentStepNumber.trim().isEmpty()) {
			expectedStepNumbers.add(context);
		} else {
			List<String> arr = Arrays.asList(currentStepNumber.split("\\.")).stream()
					.collect(Collectors.toList());
			
			// Build a possible sub-step.
			String possibleStep = arr.stream()
					.collect(Collectors.joining(".")) + ".1";
			expectedStepNumbers.add(possibleStep);
			
			// Build all possible steps.
			for (int i = arr.size() - 1; i >= 0; i--) {
				if (arr.get(i).matches("[1-9]\\d*")) {
					arr.set(i, String.valueOf(Integer.parseInt(arr.get(i)) + 1));
					
					possibleStep = arr.stream()
							.collect(Collectors.joining("."));
					
					expectedStepNumbers.add(possibleStep);
					arr.remove(i);
				}
			}
		}
		
		return expectedStepNumbers;
	}
	
	/*
	 * errorFormat(..)
	 * ---------------
	 * Wrapper for the org.eclipse.xtext.validation.error function that formats the error message.
	 */
	public void errorFormat(String errorFormat, EObject source, EStructuralFeature feature, String issue, Object... args) {
		String errorMessage = String.format(errorFormat, args);
		error(errorMessage, source, feature, issue);
	}
	
	/*
	 * warningFormat(..)
	 * ---------------
	 * Wrapper for the org.eclipse.xtext.validation.warning function that formats the error message.
	 */
	public void warningFormat(String warningFormat, EObject source, EStructuralFeature feature, String issue, Object... args) {
		String warningMessage = String.format(warningFormat, args);
		warning(warningMessage, source, feature, issue);
	}
}
