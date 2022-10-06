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

public class AbstractModeValidator {
	public static final String MAIN_STEP_REGEX = "[1-9]\\d*(\\.[1-9]\\d*)*";
	public static final String EXTENSION_STEP_REXGEX = "([1-9]\\d*|\\([1-9]\\d*-[1-9]\\d*\\))[a-zA-Z]+(\\.[1-9]\\d*([a-zA-Z]+)?)*";
	
	private Ucm4iotValidator validator;
	
	/*
	 * constructor
	 * -----------
	 * Initializes an instances of this class.
	 */
	public AbstractModeValidator(Ucm4iotValidator validator) {
		this.validator = validator;
	}
	
	
	
	/*
	 * errorFormat(..)
	 * ---------------
	 * Wrapper for the org.eclipse.xtext.validation.error function that formats the error message.
	 */
	private void errorFormat(String errorFormat, EObject source, EStructuralFeature feature, String issue, Object... args) {
		validator.errorFormat(errorFormat, source, feature, issue, args);
	}
	
	/*
	 * warningFormat(..)
	 * ---------------
	 * Wrapper for the org.eclipse.xtext.validation.warning function that formats the error message.
	 */
	private void warningFormat(String warningFormat, EObject source, EStructuralFeature feature, String issue, Object... args) {
		validator.warningFormat(warningFormat, source, feature, issue, args);
	}
}
