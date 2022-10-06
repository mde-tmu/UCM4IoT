package mde.iot.ucm4iot;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import mde.iot.ucm4iot.ucm4iot.*;
import mde.iot.ucm4iot.ucm4iot.Exception;

public class Ucm4iotUtilities {
	/*
	 * hasStepNumber(..)
	 * -----------------
	 * Returns true if a step has a step number; false otherwise.
	 */
	public static boolean hasStepNumber(Step step) {
		return (step instanceof InteractionStep | step instanceof InvocationStep);
	}
	
	/*
	 * hasStepException(..)
	 * --------------------
	 * Returns true if a step has an exception; false otherwise.
	 */
	public static boolean hasStepException(Step step) {
		if (step instanceof InteractionStep) {
			return ((InteractionStep)step).getException() != null;
		}
		
		return false;
	}
	
	/*
	 * getStepNumber(..)
	 * -----------------
	 * Gets the step number of a step.
	 */
	public static String getStepNumber(Step step) throws UnsupportedOperationException {
		if (step instanceof ConditionControlStep) {
			throw new UnsupportedOperationException("Condition and Control Flow steps do not have step numbers.");
		}
		
		// Gets the step number from interaction or invocation steps.
		if (step instanceof InteractionStep) {
			return ((InteractionStep)step).getStepNumber();
		} else {
			return ((InvocationStep)step).getStepNumber();
		}
	}
	
	/*
	 * getStepException(..)
	 * --------------------
	 * Gets the exception of a step.
	 */
	public static Exception getStepException(Step step) {
		return ((InteractionStep)step).getException();
	}
	
	/*
	 * findHandlerForException(..)
	 * ---------------------------
	 * Returns the first handler that handles the passed exception.
	 */
	public static HandlerUseCase findHandlerForException(List<HandlerUseCase> handlers, Exception exception) {
		for (HandlerUseCase handler : handlers) {
			if (handlesException(handler, exception)) {
				return handler;
			}
		}
		
		return null;
	}
	
	/*
	 * findHandlerForException(..)
	 * ---------------------------
	 * Returns the first handler that handles the passed exception.
	 */
	public static List<HandlerUseCase> findHandlersForException(List<HandlerUseCase> handlers, Exception exception) {
		List<HandlerUseCase> list = new ArrayList<HandlerUseCase>();
		for (HandlerUseCase handler : handlers) {
			if (handlesException(handler, exception)) {
				list.add(handler);
				//return handler;
			}
		}
		
		return list;
	}
	
	/*
	 * handlesException(..)
	 * --------------------
	 * Returns true if the passed handler handles the passed exception.
	 */
	public static boolean handlesException(HandlerUseCase handler, Exception exception) {
		if (handler.getContextExceptions() != null) {
			for (ContextExceptionMapping ce : handler.getContextExceptions()) {
				if (ce.getException().equals(exception)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	/*
	 * getBlocks(..)
	 * -------------
	 * Recursively gets each block in the extensions.
	 */
	public static List<ExtensionBlock> getBlocks(Extensions extensions) {
		ArrayList<ExtensionBlock> blocks = new ArrayList<>();
		extensions.getBlocks().stream()
				.forEach(b -> getBlocks(b, blocks));
		
		return blocks;
	}
	
	/*
	 * getBlocks(..)
	 * -------------
	 * Recursively gets each block in an extension block.
	 */
	private static void getBlocks(ExtensionBlock block, List<ExtensionBlock> blocks) {
		blocks.add(block);
		block.getBlocks().stream()
				.forEach(b -> getBlocks(b, blocks));
	}
	
	/*
	 * getActors(..)
	 * -------------
	 * Get the actors of a use case.
	 */
	public static ArrayList<Actor> getActors(UseCase useCase) {
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
	public static String getActorName(Actor actor) {
		if (actor instanceof PhysicalEntityActor) {
			return ((PhysicalEntityActor)actor).getName();
		} else if (actor instanceof DeviceActor) {
			return ((DeviceActor)actor).getName();
		} else if (actor instanceof SoftwareActor) {
			return ((SoftwareActor)actor).getName();
		} else {
			return ((HumanActor)actor).getName();
		}
	}
}
