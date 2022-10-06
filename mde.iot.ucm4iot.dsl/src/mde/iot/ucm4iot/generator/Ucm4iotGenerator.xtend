/*
 * generated by Xtext 2.25.0
 */
package mde.iot.ucm4iot.generator

import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet
import java.util.List
import java.util.stream.Collectors
import java.util.stream.Stream
import java.util.stream.StreamSupport
import mde.iot.ucm4iot.Ucm4iotUtilities
import mde.iot.ucm4iot.ucm4iot.Actor
import mde.iot.ucm4iot.ucm4iot.DeviceActor
import mde.iot.ucm4iot.ucm4iot.EnvironmentException
import mde.iot.ucm4iot.ucm4iot.Exception
import mde.iot.ucm4iot.ucm4iot.ExceptionalUseCase
import mde.iot.ucm4iot.ucm4iot.ExtensionBlock
import mde.iot.ucm4iot.ucm4iot.HandlerUseCase
import mde.iot.ucm4iot.ucm4iot.HardwareException
import mde.iot.ucm4iot.ucm4iot.HumanActor
import mde.iot.ucm4iot.ucm4iot.InteractionStep
import mde.iot.ucm4iot.ucm4iot.InvocationStep
import mde.iot.ucm4iot.ucm4iot.Level
import mde.iot.ucm4iot.ucm4iot.NetworkException
import mde.iot.ucm4iot.ucm4iot.OutcomeContinues
import mde.iot.ucm4iot.ucm4iot.OutcomeEndings
import mde.iot.ucm4iot.ucm4iot.OutcomeEnds
import mde.iot.ucm4iot.ucm4iot.PhysicalEntityActor
import mde.iot.ucm4iot.ucm4iot.SoftwareActor
import mde.iot.ucm4iot.ucm4iot.SoftwareException
import mde.iot.ucm4iot.ucm4iot.Step
import mde.iot.ucm4iot.ucm4iot.UseCase
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import mde.iot.ucm4iot.ucm4iot.MainScenario

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class Ucm4iotGenerator extends AbstractGenerator {
	public static final String GEN_EXCEPTION_PATH = "";
	public static final String GEN_EXCEPTION_LIST = "exceptions/";
	public static final String GEN_EXCEPTION_LIST_FORWARD = "exceptions/ft/";
	public static final String GEN_EXCEPTION_LIST_BACKWARD = "exceptions/bt/";
	public static final String GEN_INTERRUPTIONS = "interruptions/"
	public static final String GEN_USE_CASE_PATHS = "usecases/invocations/"
	
	/*
	 * doGenerate(..)
	 * --------------
	 * Generates artifacts from a UCM4IoT file.
	 */
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		
		// Generates the various artifacts.
		generateCompleteExceptions(resource, fsa, context);
		//generatePropagation(resource, fsa, context);
		//generateInterrupts(resource, fsa, context);
		//generateRecursiveCalls(resource, fsa, context);
		//generateRecursiveExceptions(resource, fsa, context);
	}
	
	/*
	 * generateCompleteExceptions(..)
	 * ------------------------------
	 * Generates a table showing the exceptions and all information related to them.
	 */
	protected def void generateCompleteExceptions(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		//var exceptions = resource.allContents.toIterable.filter(Exception);
		var useCaseList = StreamSupport.stream(resource.allContents.toIterable.filter(UseCase).spliterator(), false)
  			.collect(Collectors.toList());
  		
  		var useCases = resource.allContents.toIterable.filter(UseCase);
  		
  		// Creates a log of information to print.
  		var logs = newArrayList;
  		
  		// Produce a exception table for each use case.
  		for (useCase : useCases) {
  			var exceptions = newArrayList;
  			var interrupts = newArrayList;
  			var sources = newArrayList;
  			var levels = newArrayList;
  			var globals = newArrayList;
  			
  			generateCompleteExceptionsHelper(useCase, exceptions, sources, levels, interrupts, globals, new HashSet());
  			getGlobalExceptions(useCaseList, useCase, useCase, exceptions, sources, levels, interrupts, globals, new HashSet())
  			
  			var handlers = findRecursiveExceptionsHandlers(resource, exceptions);
  			var paths = getExceptionPaths(resource, exceptions, globals, useCase);
  			var actors = getExceptionActors(exceptions);
  			
  			var log = createCompleteExceptionsTable(useCase, exceptions, sources, levels, handlers, interrupts, paths, actors);
  			createFile(fsa, GEN_EXCEPTION_LIST, createFileName("exceptions-" + useCase.getName(), ".txt"), log);
  			logs += log;
  		}
		
		createFile(fsa, GEN_EXCEPTION_LIST, createFileName("exceptions-table", ".txt"), String.join("\n\n\n", logs));
	}
	
	/*
	 * generateCompleteExceptionsHelper(..)
	 * ------------------------------------
	 * Helper function for the generateCompleteExceptions(..) function. Recursively searches for exceptions.
	 */
	private def void generateCompleteExceptionsHelper(UseCase ctx, List<Exception> out_exceptions, List<UseCase> out_sources, List<Level> out_levels, List<String> out_interrupts, List<Boolean> out_globals, HashSet<UseCase> visited) {
		if (ctx === null || visited.contains(ctx)) {
			return;
		}
		
		// Extract data from current use case.
		if (ctx.extensions !== null) {
			var foundExceptions = Ucm4iotUtilities.getBlocks(ctx.extensions).stream
					.map([block | block.getSteps()])
					.flatMap([steps | steps.stream])
					.filter([step | step instanceof InteractionStep])
					.map([step | step as InteractionStep])
					.filter([step | step.exception !== null])
					.map([step | step.exception])
					.collect(Collectors.toList());
			
			// Add row of data.
			for (exception : foundExceptions) {
				out_exceptions.add(exception);
				out_interrupts.add(getInterruptType(exception));
				
				var source = EcoreUtil2.getContainerOfType(exception, UseCase);
				out_sources.add(source);
				out_levels.add(source.level);
				out_globals.add(false);
			}
		}
		
		// Depth-first search.
		visited.add(ctx);
		
		// Recursively searches through each use case.
		var invokedUseCases = getInvokedUseCases(ctx);
		for (invokedUseCase : invokedUseCases) {
			generateCompleteExceptionsHelper(invokedUseCase, out_exceptions, out_sources, out_levels, out_interrupts, out_globals, visited);
		}
		
		//visited.remove(ctx);
	}
	
	private def void getGlobalExceptions(List<UseCase> useCases, UseCase start, UseCase ctx, List<Exception> out_exceptions, List<UseCase> out_sources, List<Level> out_levels, List<String> out_interrupts, List<Boolean> out_globals, HashSet<UseCase> visited) {
		if (ctx === null || visited.contains(ctx)) {
			return;
		}
		
		// Extract data from current use case. Skips overlap with other use case.
		if (ctx.extensions !== null) {
			var foundExceptions = Ucm4iotUtilities.getBlocks(ctx.extensions).stream
					.map([block | block.getSteps()])
					.flatMap([steps | steps.stream])
					.filter([step | step instanceof InteractionStep])
					.map([step | step as InteractionStep])
					.filter([step | step.exception !== null])
					.map([step | step.exception])
					.collect(Collectors.toList());
			
			// Add row of data.
			for (exception : foundExceptions) {
				if (!out_exceptions.contains(exception)) {
					if (exception instanceof EnvironmentException) {
						out_exceptions.add(exception);
						out_interrupts.add(getInterruptType(exception));
						
						var source = EcoreUtil2.getContainerOfType(exception, UseCase);
						out_sources.add(start);
						out_levels.add(start.level);
						out_globals.add(true); // TODO: this is true
					}
				}
			}
		}
		
		// Depth-first search.
		visited.add(ctx);
		
		// List parent use cases.
		var parents = findInvokingUseCases(useCases, ctx);
		//var parents = getInvokedUseCases(ctx);
		for (parent : parents) {
			getGlobalExceptions(useCases, start, parent, out_exceptions, out_sources, out_levels, out_interrupts, out_globals, visited);
		}
		
		
	}
	
	private def HashMap<Exception, List<Actor>> getExceptionActors(List<Exception> exceptions) {
		var actorMap = new HashMap<Exception, List<Actor>>();
		
		// Find all actors related to the exception.
		for (exception : exceptions) {
			var useCase = EcoreUtil2.getContainerOfType(exception, UseCase);
			var step = EcoreUtil2.getContainerOfType(exception, Step);
			
			// Filter for actors mentioned in the relevant steps.
			var actors = new HashSet<Actor>();
			var list = #[step];
			getExceptionActorsHelper(useCase, list, Ucm4iotUtilities.getActors(useCase), actors);
			
			// Find all actors.
			//var actorNames = Ucm4iotUtilities.getActors(useCase).stream()
			//		.map([actor | Ucm4iotUtilities.getActorName(actor)])
			//		.collect(Collectors.toList());
			
			actorMap.put(exception, new ArrayList<Actor>(actors));
		}
		
		return actorMap;
	}
	
	private def void getExceptionActorsHelper(UseCase useCase, List<Step> steps, List<Actor> possibleActors, HashSet<Actor> out_actors) {
		if (steps.size == 0) {
			return;
		}
		
		// Filter for actors found within the list of steps
		for (step : steps) {
			var isInvocation = step instanceof InvocationStep;
			var hasException = Ucm4iotUtilities.hasStepException(step);
			
			if (!step.isIgnoreDescription && !isInvocation && !hasException) {
				var actorsInStep = possibleActors.stream()
						.filter([actor | hasWord(step, Ucm4iotUtilities.getActorName(actor))])
						.collect(Collectors.toSet());
				
				out_actors.addAll(actorsInStep);
			}
		}
		
		var block = EcoreUtil2.getContainerOfType(steps.get(0), ExtensionBlock);
		if (block !== null) {
			var parentStep = block.refStep;
			
			// Get parent steps;
			var list = newArrayList;
			list.add(parentStep);
			
			if (block.hasRangedRef) {
				var flow = getSurroundingStep(parentStep).stream()
						.collect(Collectors.toList());
				
				var include = false;
				for (s : flow) {
					if (s === block.refStep) {
						include = true;
					} else if (s === block.endRefStep) {
						include = false;
					}
					
					if (include == true) {
						list.add(s);
					}
				}
			}
			
			getExceptionActorsHelper(useCase, list, possibleActors, out_actors);
		}
	}
	
	def List<Step> getSurroundingStep(Step step) {
		var steps = newArrayList;
		
		if (step.eContainer() instanceof ExtensionBlock) {
			var block = EcoreUtil2.getContainerOfType(step, ExtensionBlock);
			steps = new ArrayList<Step>(block.steps);
		} else if (step.eContainer() instanceof MainScenario) {
			var main = EcoreUtil2.getContainerOfType(step, MainScenario);
			steps = new ArrayList<Step>(main.steps);
		}
		
		return steps;
	}
	
	/*
	 * hasWord(..)
	 * -----------
	 * Returns true if a step has the passed word; false otherwise.
	 */
	def boolean hasWord(Step step, String value) {
		var description = step.getDescription();
		if (description === null) {
			description = "";
		}
		
		var words = description
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
	
	private def HashMap<Exception, List<String>> getExceptionPaths(Resource resource, List<Exception> exceptions, List<Boolean> globals, UseCase ctx) {
		var useCases = StreamSupport.stream(resource.allContents.toIterable.filter(UseCase).spliterator(), false)
  			.collect(Collectors.toList());
  		var handlers = StreamSupport.stream(resource.allContents.toIterable.filter(HandlerUseCase).spliterator(), false)
  			.collect(Collectors.toList());
		
		// Recursively searches through each use case.
		var exceptionMap = new HashMap<Exception, List<String>>();
		
		for (var n = 0; n < exceptions.size; n++) {
			var exception = exceptions.get(n);
			var isGlobal = globals.get(n);
			
			var parentHandlers = Ucm4iotUtilities.findHandlersForException(handlers, exception);
			var parentHandlerPaths = new ArrayList<String>();
			
			for (handler : parentHandlers) {
				var parentHandlerUseCases = newArrayList;
				var parentHandlerLevels = newArrayList;
				
				getExceptionPathsHelper(useCases, parentHandlerUseCases, parentHandlerLevels, handler, exception, 0, new HashSet());
				
				for (var i = 0; i < parentHandlerUseCases.size; i++) {
					var path = createPropagationPath(parentHandlerUseCases, parentHandlerLevels, i);
					
					if (path.startsWith(handler.name)) {
						path = path.replaceFirst(handler.name, "{" + handler.name + "}")
						parentHandlerPaths.add(path);
					}
				}
			}
			
			// Find invocation paths.
			var source = EcoreUtil2.getContainerOfType(exception, UseCase);
			var parentUseCases = newArrayList;
			var levels = newArrayList;
			
			getExceptionPathsHelper(useCases, parentUseCases, levels, source, exception, 0, new HashSet());
			
			// Adds the paths to the exception.
			var paths = new ArrayList<String>();
			for (var i = 0; i < parentUseCases.size; i++) {
				var path = createPropagationPath(parentUseCases, levels, i);
				
				if (isGlobal) {
					if (parentHandlerPaths.size > 0) {
						for (handlerPath : parentHandlerPaths) {
								paths.add("GLOBAL::" + ctx.name + " >> " + handlerPath);  // TODO: change to the name of the use case.
						}
					} else {
						paths.add("GLOBAL::" + ctx.name + " >> {~No Handler~}");
					}
				} else {
					if (path.startsWith(ctx.name)) {
						if (parentHandlerPaths.size > 0) {
							for (handlerPath : parentHandlerPaths) {
								paths.add(path + " >> " + handlerPath);
							}
						} else {
							paths.add(path + " >> {~No Handler~}");
						}
					}
				}
			}
			
			exceptionMap.put(exception, paths);
		}
		
		return exceptionMap;
	}
	
	private def void getExceptionPathsHelper(List<UseCase> useCases, List<UseCase> containers, List<Integer> levels, UseCase current, Exception exception, int level, HashSet<UseCase> visited) {
		if (current === null || visited.contains(current)) {
			return;
		}
		
		// Add current use case to the list of use cases.
		containers.add(current);
		levels.add(level);
		
		// Do depth-first search.
		visited.add(current);
		
		// List parent use cases.
		var parents = findInvokingUseCases(useCases, current);
		for (parent : parents) {
			generatePropagationHelper(useCases, containers, levels, parent, level+1, visited);
		}
		
		visited.remove(current);
	}
	
	
	// TODO: move to utilities
	private def List<UseCase> getInvokedUseCases(UseCase ctx) {
		// Get all invoked use cases in the main scenario.
		var invokedUseCases = ctx.main.steps.stream
				.filter([step | step instanceof InvocationStep])
				.map([step | step as InvocationStep])
				.filter([step | step.invokedUseCase !== null])
				.map([step | step.invokedUseCase])
				.collect(Collectors.toList());
		
		// Get all invoked use cases in the extensions.
		if (ctx.extensions !== null) {
			var extensionsInvokedUseCases = Ucm4iotUtilities.getBlocks(ctx.extensions).stream
					.map([block | block.getSteps()])
					.flatMap([steps | steps.stream])
					.filter([step | step instanceof InvocationStep])
					.map([step | step as InvocationStep])
					.filter([step | step.invokedUseCase !== null])
					.map([step | step.invokedUseCase])
					.collect(Collectors.toList());
			
			invokedUseCases = Stream.concat(invokedUseCases.stream, extensionsInvokedUseCases.stream).collect(Collectors.toList());
		}
		
		return invokedUseCases;
	}
	
	/*
	 * createCompleteExceptionsTable(..)
	 * ---------------------------------
	 * Creates a table for the generateCompleteExceptions(..) function.
	 */
	private def String createCompleteExceptionsTable(UseCase src, List<Exception> exceptions, List<UseCase> sources, List<Level> levels, List<HandlerUseCase> handlers, List<String> interrupts, HashMap<Exception, List<String>> exceptionPaths, HashMap<Exception, List<Actor>> exceptionActors) {
		var rows = newArrayList;
		
		// Creates the format of the table.
		var columns = #[22, 26, 25, 30, 20, 24, 180];
		var titleFormat = createTableFormat(columns.stream.reduce(0, [a,b | a+b]) + columns.size - 1);
		var titleLine = String.format(titleFormat, "").replace(" ", "-").replace("|", "+");
		var format = createTableFormat(columns);
		var line = String.format(format, "", "", "", "", "", "", "").replace(" ", "-").replace("|", "+");
		var subLine = String.format(line
			.replaceFirst("-+", String.format("%%-%ds", columns.get(0)))
			.replaceFirst("\\+", "|"), ""
		);
		
		// Adds the title of the table.
		rows += titleLine;
		if (src instanceof ExceptionalUseCase) {
			rows += String.format(titleFormat, " Exceptional Use Case: " + src.name);
		} else if (src instanceof HandlerUseCase) {
			rows += String.format(titleFormat, " Handler Use Case: " + src.name);
		}
		
		// Builds the content of the table.
		rows += line;
		rows += String.format(format, " Exception Type", " Exception Name", " Exception Source", " Associated Actors", " Handler", " Interrupt Type", " Path >> {HANDLER}");
		rows += line;
		
		// Sort the exceptions into their type.
		var types = #[typeof(HardwareException), typeof(SoftwareException), typeof(NetworkException), typeof(EnvironmentException)];
		for (type : types) {
			var newGroup = 0;
			var elmAdded = false;
			
			// Looks through every exception.
			for (var i = 0; i < exceptions.size; i++) {
				var exception = exceptions.get(i);
				var source = sources.get(i);
				var level = levels.get(i);
				var handler = handlers.get(i);
				var paths = exceptionPaths.get(exception);
				var actors = exceptionActors.get(exception);
				
				// Filters for exceptions of a type.
				if (type.isInstance(exception)) {
					var exceptionGroup = (newGroup++ == 0) ? (" " + type.getSimpleName()) : "";
					var exceptionName = " " + exception.name;
					var sourceName = " " + source.name;
					var sourceLevel = " " + level;
					var handlerName = (handler !== null) ? (" " + handler.name) : " n/a";
					var interruptType = " " + interrupts.get(i);
					
					// Logic for printing out rows in a organized way.
					if (actors.size > 0) {
						var actorName = " "+ getActorNameAndType(actors.get(0));
						var path = " " + paths.get(0);
						var depth = " " + path.split("->").length;
						rows += String.format(format, exceptionGroup, exceptionName, sourceName, actorName, handlerName, interruptType, path);
					} else {
						var path = " " + paths.get(0);
						var depth = " " + path.split("->").length;
						rows += String.format(format, exceptionGroup, exceptionName, sourceName, " n/a", handlerName, interruptType, path);
					}
					
					var j = 1;
					for (; j < paths.size && j < actors.size; j++) {
						var actorName = " " + getActorNameAndType(actors.get(j));
						var path = " " + paths.get(j);
						var depth = " " + path.split("->").length;
						rows += String.format(format, "", "", "", actorName, "", "", path);
					}
					
					for (; j < paths.size; j++) {
						var path = " " + paths.get(j);
						var depth = " " + path.split("->").length;
						rows += String.format(format, "", "", "", "", "", "", path);
					}
					
					for (; j < actors.size; j++) {
						var actorName = " " + getActorNameAndType(actors.get(j));
						rows += String.format(format, "", "", "", actorName, "", "", "");
					}
					
					rows += subLine;
					elmAdded = true;
				}
			}
			
			// Removes the last subLine.
			if (rows.get(rows.size - 1).equals(subLine)) {
				rows.remove(rows.size - 1);
			}
			
			// Adds a line at the bottom of a group of exceptions if at least one exception was added.
			if (elmAdded) {
				rows += line;
			}
		}
		
		return String.join("\n", rows);
	}
	
	/*
	 * createTableFormat(..)
	 * ---------------------
	 * Creates the format of a table.
	 */
	private def String createTableFormat(int... columnSizes) {
		var formatBuilder = new StringBuilder();
		
		// Builds the format.
		for (size : columnSizes) {
			formatBuilder.append(String.format(" %%-%ds ", size));
		}
		
		return formatBuilder
				.toString()
				.replaceAll(" +", " ")
				.replaceAll(" ", "|");
	}
	
	
	/*
	 * getActorNameAndType(..)
	 * -----------------------
	 * Gets the name of an actor.
	 */
	def String getActorNameAndType(Actor actor) {
		if (actor instanceof PhysicalEntityActor) {
			return "PHYSICAL_ENTITY::" + (actor as PhysicalEntityActor).getName();
		} else if (actor instanceof DeviceActor) {
			return "DEVICE::" + (actor as DeviceActor).getName();
		} else if (actor instanceof SoftwareActor) {
			return "SOFTWARE::" + (actor as SoftwareActor).getName();
		} else {
			return "HUMAN::" + (actor as HumanActor).getName();
		}
	}
	
	/*
	 * generatePropagation(..)
	 * -----------------------
	 * Generates a table showing where exceptions get propagated to.
	 */
	protected def void generatePropagation(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var exceptions = resource.allContents.toIterable.filter(Exception);
		var useCases = StreamSupport.stream(resource.allContents.toIterable.filter(UseCase).spliterator(), false)
  			.collect(Collectors.toList());
		
		// Recursively searches through each use case.
		for (exception : exceptions) {
			var source = EcoreUtil2.getContainerOfType(exception, UseCase);
			var parentUseCases = newArrayList;
			var levels = newArrayList;
			
			generatePropagationHelper(useCases, parentUseCases, levels, source, 0, new HashSet());
			
			// Write information to file.
			var log = createPropagationTable(parentUseCases, levels);
			createFile(fsa, GEN_EXCEPTION_LIST_BACKWARD, createFileName("bt-exceptions-" + source.getName() + "-" + exception.getName(), ".txt"), log);
		}
	}
	
	/*
	 * generatePropagationHelper(..)
	 * -----------------------------
	 * Helper function for the generatePropagation(..) function. Recursively finds calling use cases.
	 */
	private def void generatePropagationHelper(List<UseCase> useCases, List<UseCase> containers, List<Integer> levels, UseCase current, int level, HashSet<UseCase> visited) {
		if (current === null || visited.contains(current)) {
			return;
		}
		
		// Add current use case to the list of use cases.
		containers.add(current);
		levels.add(level);
		
		// Do depth-first search.
		visited.add(current);
		
		// List parent use cases.
		var parents = findInvokingUseCases(useCases, current);
		for (parent : parents) {
			generatePropagationHelper(useCases, containers, levels, parent, level+1, visited);
		}
		
		visited.remove(current);
	}
	
	/*
	 * createPropagationTable(..)
	 * --------------------------
	 * Creates a table for the generatePropagation(..) function.
	 */
	private def String createPropagationTable(List<UseCase> parentUseCases, List<Integer> levels) {
		var Ns = #[30, 15, 180];
		
		// Constants and helpers.
		var format = "|%" + -(Ns.get(0)) + "s|%" + -(Ns.get(1)) + "s|%" + -(Ns.get(2)) + "s|";
		var line = String.format(format, "", "", "").replace(" ", "-").replace("|", "+");
		
		// Create the table.
		var rows = newArrayList;
		rows += line;
		rows += String.format(format, " Propagated To", " Level", " Propagation Path");
		rows += line;
		
		// Populate the table.
		for (var i = 0; i < parentUseCases.size; i++) {
			var useCaseName = " " + parentUseCases.get(i).name;
			var level = " " + levels.get(i);
			var path = " " + createPropagationPath(parentUseCases, levels, i);
			
			rows += String.format(format, useCaseName, level, path);
			rows += line;
		}
		
		return String.join("\n", rows);
	}
	
	/*
	 * createPropagationPath(..)
	 * -------------------------
	 * Creates a propagation path for the generatePropagation(..) function.
	 */
	private def String createPropagationPath(List<UseCase> parentUseCases, List<Integer> levels, int index) {
		var path = new StringBuilder();
		path.append(parentUseCases.get(index).name);
		
		// Finds the path.
		var level = levels.get(index) - 1;
		for (var i = index; i >= 0; i--) {
			if (levels.get(i) == level) {
				path.append(" -> ");
				path.append(parentUseCases.get(i).name);
				level--;
			}
		}
		
		return path.toString();
	}
	
	
	// TODO: move to utilities
	private def List<UseCase> findInvokingUseCases(List<UseCase> useCases, UseCase invokedUseCase) {
		var parentUseCases = newArrayList;
		
		// For each use case, determine if it invokes the invoked use case.
		for (useCase : useCases) {
			var foundInMain = useCase.main.steps.stream
					.filter([step | step instanceof InvocationStep])
					.map([step | step as InvocationStep])
					.anyMatch([step | step.invokedUseCase == invokedUseCase]);
			
			var foundInExtensions = false;
			if (useCase.extensions !== null) {
				foundInExtensions = Ucm4iotUtilities.getBlocks(useCase.extensions).stream
						.map([block | block.getSteps()])
						.flatMap([steps | steps.stream])
						.filter([step | step instanceof InvocationStep])
						.map([step | step as InvocationStep])
						.anyMatch([step | step.invokedUseCase == invokedUseCase]);
			}
			
			// If use case calls the invoked use case anywhere, then add it to the list of parents
			if (foundInMain || foundInExtensions) {
				parentUseCases.add(useCase);
			}
		}
		
		return parentUseCases;
	}
	
	/*
	 * generateInterrupts(..)
	 * ----------------------
	 * Generates a table that shows the type of interruptions that occur for each exception.
	 */
	protected def void generateInterrupts(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var exceptions = resource.allContents.toIterable.filter(Exception);
		var handlers = StreamSupport.stream(resource.allContents.toIterable.filter(HandlerUseCase).spliterator(), false)
  			.collect(Collectors.toList());
		
		// Allocate data for table information.
		var r_exceptions = newArrayList;
		var r_useCases = newArrayList;
		var r_handlers = newArrayList;
		var r_interrupts = newArrayList;
		
		// Looks at each exception and its context.
		for (exception : exceptions) {
			var useCase = EcoreUtil2.getContainerOfType(exception, UseCase);
			var handler = Ucm4iotUtilities.findHandlerForException(handlers, exception);
			var interrupt = getInterruptType(exception);
			
			// Add row into table.
			r_exceptions.add(exception);
			r_useCases.add(useCase);
			r_handlers.add(handler);
			r_interrupts.add(interrupt);
		}
		
		// Write information to file.
		var log = createInterruptsTable(r_exceptions, r_useCases, r_handlers, r_interrupts);
		createFile(fsa, GEN_INTERRUPTIONS, createFileName("interruptions", ".txt"), log);
	}
	
	/*
	 * createInterruptsTable(..)
	 * -------------------------
	 * Creates a table for the generateInterrupts(..) function.
	 */
	private def String createInterruptsTable(List<Exception> exceptions, List<UseCase> useCases, List<HandlerUseCase> handlers, List<String> interrupts) {
		var Ns = #[30, 30, 30, 30]
		
		// Constants and helpers.
		var format = "|%" + -(Ns.get(0)) + "s|%" + -(Ns.get(1)) + "s|%" + -(Ns.get(2)) + "s|%" + -(Ns.get(3))+ "s|";
		var line = String.format(format, "", "", "", "").replace(" ", "-").replace("|", "+");
		
		// Create the table.
		var rows = newArrayList;
		rows += line;
		rows += String.format(format, " Exception Name", " Source", " Handler", " Interrupt Type")
		rows += line;
		
		// Populate the table.
		for (var i = 0; i < exceptions.size; i++) {
			var exceptionName = " " + exceptions.get(i).getName();
			var sourceName =    " " + useCases.get(i).getName();
			var handlerName =   " " + handlers.get(i).getName;
			var interruptType = " " + interrupts.get(i);
			
			rows += String.format(format, exceptionName, sourceName, handlerName, interruptType);
			rows += line;
		}
		
		return String.join("\n", rows);
	}	
	
	/*
	 * generateRecursiveExceptions(..)
	 * -------------------------------
	 * Generates a table that shows all possible exceptions that can occur in a use case. This includes recursively invoked use cases.
	 */
	protected def void generateRecursiveExceptions(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var useCases = resource.allContents.toIterable.filter(UseCase);
		
		// Recursively searches through each use case.
		for (useCase : useCases) {
			var exceptions = newArrayList;
			var contexts = newArrayList;
			var interrupts = newArrayList;
			
			generateRecursiveExceptionsHelper(useCase, 0, exceptions, contexts, interrupts, new HashSet);
			
			var handlers = findRecursiveExceptionsHandlers(resource, exceptions);
			
			// Write information to file.
			var log = createRecursiveExceptionsTable(exceptions, contexts, handlers, interrupts);
			createFile(fsa, GEN_EXCEPTION_LIST_FORWARD, createFileName("ft-exceptions-" + useCase.getName(), ".txt"), log);
		}
	}
	
	/*
	 * generateRecursiveExceptionsHelper(..)
	 * -------------------------------------
	 * Helper function to the generateRecursiveExceptions(..) function. Recursively searches through each use case.
	 */
	private def void generateRecursiveExceptionsHelper(UseCase useCase, int level, List<Exception> exceptions, List<UseCase> contexts, List<String> interrupts, HashSet<UseCase> visited) {
		if (useCase === null || visited.contains(useCase)) {
			return;
		}
		
		// Generate data.
		if (useCase.extensions !== null) {
			var foundExceptions = Ucm4iotUtilities.getBlocks(useCase.extensions).stream
					.map([block | block.getSteps()])
					.flatMap([steps | steps.stream])
					.filter([step | step instanceof InteractionStep])
					.map([step | step as InteractionStep])
					.filter([step | step.exception !== null])
					.map([step | step.exception])
					.collect(Collectors.toList());
			
			// Add row of data.
			for (exception : foundExceptions) {
				exceptions.add(exception);
				interrupts.add(getInterruptType(exception));
				contexts.add(useCase);
			}
		}
		
		visited.add(useCase);  // Adds the newly visited use case to the set of visited use cases.
		
		// Get all invoked use cases in the main scenario.
		var useCases = useCase.main.steps.stream
				.filter([step | step instanceof InvocationStep])
				.map([step | step as InvocationStep])
				.filter([step | step.invokedUseCase !== null])
				.map([step | step.invokedUseCase])
				.collect(Collectors.toList());
		
		// Get all invoked use cases in the extensions.
		if (useCase.extensions !== null) {
			var extensionsInvokedUseCases = Ucm4iotUtilities.getBlocks(useCase.extensions).stream
					.map([block | block.getSteps()])
					.flatMap([steps | steps.stream])
					.filter([step | step instanceof InvocationStep])
					.map([step | step as InvocationStep])
					.filter([step | step.invokedUseCase !== null])
					.map([step | step.invokedUseCase])
					.collect(Collectors.toList());
			
			useCases = Stream.concat(useCases.stream, extensionsInvokedUseCases.stream).collect(Collectors.toList());
		}
		
		// Recursively searches through each use case.
		for (uc : useCases) {
			generateRecursiveExceptionsHelper(uc, level+1, exceptions, contexts, interrupts, visited);
		}
	}
	
	// TODO: move to utilities class
	private def String getInterruptType(Exception exception) {
		// Determine the type of interrupt.
		var block = EcoreUtil2.getContainerOfType(exception, ExtensionBlock);  // TODO: check handler exists			
		if (block.outcome instanceof OutcomeContinues) {
			return "Interrupt and continue"
		} else {
			var outcome = block.outcome as OutcomeEnds;
			
			if (outcome.type == OutcomeEndings.FAILURE) {
				return "Interrupt and fail"
			} else {
				return "Unknown"
			}
		}
	}
	
	/*
	 * findRecursiveExceptionsHandlers(..)
	 * -----------------------------------
	 * Finds handlers for the exceptions found in the generateRecursiveExceptions(..) function.
	 */
	private def List<HandlerUseCase> findRecursiveExceptionsHandlers(Resource resource, List<Exception> exceptions) {
		var potentialHandlers = StreamSupport.stream(resource.allContents.toIterable.filter(HandlerUseCase).spliterator(), false)
				.collect(Collectors.toList());				
		
		// Create a empty list.
		var handlers = newArrayList;
		
		// For each exception, attempt to find a handler that handles it.
		for (exception : exceptions) {
			handlers.add(Ucm4iotUtilities.findHandlerForException(potentialHandlers, exception));
		}
		
		return handlers;
	}
	
	/*
	 * createRecursiveExceptionsTable(..)
	 * ----------------------------------
	 * Creates a table for the generateRecursiveExceptions(..) function.
	 */
	private def String createRecursiveExceptionsTable(List<Exception> exceptions, List<UseCase> contexts, List<HandlerUseCase> handlers, List<String> interrupts) {
		var Ns = #[25, 30, 30, 20, 30, 30]
		
		// Constants and helpers.
		var format = "|%" + -(Ns.get(0)) + "s|%" + -(Ns.get(1)) + "s|%" + -(Ns.get(2)) + "s|%" + -(Ns.get(3))+ "s|%" + -(Ns.get(4))+ "s|%" +  -(Ns.get(5)) + "s|";
		var line = String.format(format, "", "", "", "", "", "").replace(" ", "-").replace("|", "+");
		
		// Create the table.
		var rows = newArrayList;
		rows += line;
		rows += String.format(format, " Exception Type", " Exception Name", " Source", " Source Type", " Handler", " Interrupt Type")
		rows += line;
		
		// Populate the table.
		var types = #[typeof(HardwareException), typeof(SoftwareException), typeof(NetworkException), typeof(EnvironmentException)];
		for (type : types) {
			var newGroup = 0;
			var elmAdded = false;
			
			// Looks through every exception.
			for (var i = 0; i < exceptions.size; i++) {
				var exception = exceptions.get(i);
				var context = contexts.get(i);
				var handler = handlers.get(i);
				var interrupt = interrupts.get(i);
				
				// Filters for exceptions of a type.
				if (type.isInstance(exception)) {
					var exceptionGroup = (newGroup++ == 0) ? (" " + type.getSimpleName()) : "";
					var exceptionName = " " + exception.name;
					var exceptionContext = " " + context.name;
					var exceptionSource = (context instanceof ExceptionalUseCase) ? " Exceptional": " Handler";
					var exceptionHandler = (handler !== null) ? (" " + handler.name) : " N/A";
					var exceptionInterrupt = " " + interrupt;
					
					rows += String.format(format, exceptionGroup, exceptionName, exceptionContext, exceptionSource, exceptionHandler, exceptionInterrupt);
					elmAdded = true;
				}
			}
			
			// Adds a line at the bottom of a group of exceptions if at least one exception was added.
			if (elmAdded) {
				rows += line;
			}
		}
		
		return String.join("\n", rows);
	}
	
	/*
	 * generateRecursiveCalls(..)
	 * --------------------------
	 * Generates use case invocation summary list.
	 */
	protected def void generateRecursiveCalls(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var useCases = resource.allContents.toIterable.filter(UseCase);
		
		// Recursively searches through each use case.
		for (useCase : useCases) {
			var data = newArrayList;    // Prepares data to write into a file.
			
			// Starts search.
			generateRecursiveCallsHelper(useCase, 0, fsa, context, data, new HashSet);
			
			// Write information to file.
			var log = String.join("\n", data);
			createFile(fsa, GEN_USE_CASE_PATHS, createFileName("invocation-" + useCase.getName(), ".txt"), log);
		}
	}
	
	/*
	 * generateRecursiveCallsHelper(..)
	 * --------------------------------
	 * Helper function for the generateRecursiveCalls(..) function. Recursively searches through each use case.
	 */
	private def void generateRecursiveCallsHelper(UseCase useCase, int level, IFileSystemAccess2 fsa, IGeneratorContext context, ArrayList<String> data, HashSet<UseCase> visited) {
		if (useCase === null) {
			return;
		}
		
		// If use case has already been visited, then stop.
		if (visited.contains(useCase)) {
			var sb = new StringBuilder;
			for (var i = 0; i < level; i++) {
				sb.append("-> ")
			}
			sb.append(useCase.name)
			sb.append("-> already visited")
			data += sb.toString()
			
			return;
		}
		
		// Outputs data.
		if (level == 0) {
			data += "Root Use Case: " + useCase.name
		} else {
			var sb = new StringBuilder;
			for (var i = 0; i < level; i++) {
				sb.append("-> ")
			}
			sb.append(useCase.name)
			data += sb.toString()
		}
		
		visited.add(useCase);  // Adds the newly visited use case to the set of visited use cases.
				
		// Get all invoked use cases in the main scenario.
		var mainInvokedUseCases = useCase.main.steps.stream
				.filter([step | step instanceof InvocationStep])
				.map([step | step as InvocationStep])
				.filter([step | step.invokedUseCase !== null])
				.map([step | step.invokedUseCase])
				.collect(Collectors.toList());
		
		// Get all invoked use cases in the extensions.		
		if (useCase.extensions !== null) {
			var extensionsInvokedUseCases = Ucm4iotUtilities.getBlocks(useCase.extensions).stream
					.map([block | block.getSteps()])
					.flatMap([steps | steps.stream])
					.filter([step | step instanceof InvocationStep])
					.map([step | step as InvocationStep])
					.filter([step | step.invokedUseCase !== null])
					.map([step | step.invokedUseCase])
					.collect(Collectors.toList());
			
			var useCases = Stream.concat(mainInvokedUseCases.stream, extensionsInvokedUseCases.stream).collect(Collectors.toList());
			
			// Recursively searches through each use case.
			for (uc : useCases) {
				generateRecursiveCallsHelper(uc, level+1, fsa, context, data, visited);
			}
		} else {
			// Recursively searches through each use case.
			for (uc : mainInvokedUseCases) {
				generateRecursiveCallsHelper(uc, level+1, fsa, context, data, visited);
			}
		}
	}
	
	/*
	 * createFileName(..)
	 * ------------------
	 * Creates a file name with a given file extension.
	 */
	private def String createFileName(String name, String ext) {
		if (ext !== null && ext.trim().isEmpty() && !ext.startsWith(".")) {
			throw new IllegalArgumentException("File extension is not valid. Make sure passed argument begins with '.'");
		}
		
		return name + ext;
	}
	
	/*
	 * createFile(..)
	 * --------------
	 * Creates a file.
	 */
	private def void createFile(IFileSystemAccess2 fsa, String path, String file, String data) {
		fsa.generateFile(path + "/" + file, data);
	}
}
