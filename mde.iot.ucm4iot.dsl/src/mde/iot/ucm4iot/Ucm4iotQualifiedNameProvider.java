package mde.iot.ucm4iot;

import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import mde.iot.ucm4iot.ucm4iot.*;

/*
 * Ucm4iotQualifiedNameProvider
 * ----------------------------
 * Computes the fully qualified name of an EObject by first invoking a method 
 * QualifiedName qualifiedName(MyType ele) reflectively.
 */
public class Ucm4iotQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {
	
	/**
	 * qualifiedName(Step)
	 * -------------------
	 * Gets the qualified name for a step. Overrides the default implementation.
	 * @param step 
	 * @return
	 */
	public QualifiedName qualifiedName(Step step) {
		if (Ucm4iotUtilities.hasStepNumber(step)) {
			String[] stepNumberSegments = Ucm4iotUtilities.getStepNumber(step)
					.replaceAll("\\s+","")
					.split("\\.");
			
			return QualifiedName.create(stepNumberSegments);
		}
		
		return null;
	}
}
