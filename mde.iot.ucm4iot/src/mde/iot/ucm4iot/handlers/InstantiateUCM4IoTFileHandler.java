package mde.iot.ucm4iot.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import mde.iot.ucm4iot.wizards.UCM4IoTProjectWizard;

/*
 * Handler: InstantiateUCM4IoTFileHandler
 * --------------------------------------
 * - handles instantiating UCM4IoT files.
 */
public class InstantiateUCM4IoTFileHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		openWizard(event);
		
		return null;
	}
	
	public void openWizard(ExecutionEvent event) throws ExecutionException
	{
	  Shell activeShell = HandlerUtil.getActiveShell(event);
	  IWizard wizard = new UCM4IoTProjectWizard();
	  WizardDialog dialog = new WizardDialog(activeShell, wizard);
	  dialog.open();
	}
}
