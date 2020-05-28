package org.openmrs.module.kenyaemropd.metadata;

import org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle;
import org.openmrs.module.metadatadeploy.bundle.Requires;
import org.springframework.stereotype.Component;

import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.idSet;
import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.privilege;
import static org.openmrs.module.metadatadeploy.bundle.CoreConstructors.role;

/**
 * Implementation of access control to the app.
 */
@Component
@Requires(org.openmrs.module.kenyaemr.metadata.SecurityMetadata.class)
public class KenyaemropdSecurityMetadata extends AbstractMetadataBundle {
	
	public static class _Privilege {
		
		public static final String APP_OPD_MODULE_APP = "App: kenyaemropd.home";
	}
	
	public static final class _Role {
		
		public static final String APPLICATION_OPD_MODULE = "KenyaEMR OPD Module";
	}
	
	/**
	 * @see AbstractMetadataBundle#install()
	 */
	@Override
	public void install() {
		
		install(privilege(_Privilege.APP_OPD_MODULE_APP, "Able to access KenyaEMR OPD module features"));
		install(role(_Role.APPLICATION_OPD_MODULE, "Can access KenyaEMR OPD module App",
		    idSet(org.openmrs.module.kenyaemr.metadata.SecurityMetadata._Role.API_PRIVILEGES_VIEW_AND_EDIT),
		    idSet(_Privilege.APP_OPD_MODULE_APP)));
	}
}
