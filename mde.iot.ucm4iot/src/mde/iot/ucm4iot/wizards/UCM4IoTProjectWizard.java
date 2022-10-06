package mde.iot.ucm4iot.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;


import java.net.URI;

public class UCM4IoTProjectWizard extends Wizard implements INewWizard {
	private static final String WIZARD_NAME = "New UCM4IoT Project"; //$NON-NLS-1$
	private static final String PAGE_NAME = "UCM4IoT Project Wizard"; //$NON-NLS-1$
	
	private WizardNewProjectCreationPage pageOne;
	
	public UCM4IoTProjectWizard() {
		setWindowTitle(WIZARD_NAME);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		
	}

	@Override
	public boolean performFinish() {
		
		String name = pageOne.getProjectName();
	    URI location = null;
	    if (!pageOne.useDefaults()) {
	        location = pageOne.getLocationURI();
	    } // else location == null
	 
	    UCM4IoTProjectSupport.createProject(name, location);
	 
		return true;
	}
	
	@Override
	public void addPages() {
		super.addPages();
		
		pageOne = new WizardNewProjectCreationPage(PAGE_NAME);
		pageOne.setTitle(UCM4IoTWizardMessages.UCM4IoTProjectWizard_UCM4IoT_Project);
		pageOne.setDescription(UCM4IoTWizardMessages.UCM4IoTProjectWizard_Create_UCM4IoT_Project);
		
		addPage(pageOne);
	}

}
