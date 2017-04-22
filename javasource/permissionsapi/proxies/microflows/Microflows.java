// This file was generated by Mendix Modeler 7.2.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package permissionsapi.proxies.microflows;

import java.util.HashMap;
import java.util.Map;
import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.MendixRuntimeException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class Microflows
{
	// These are the microflows for the PermissionsAPI module
	public static java.util.List<permissionsapi.proxies.AppRole> getRolesForOpenID(IContext context, java.lang.String _openID, java.lang.String _environmentID, java.lang.String _environmentPassword)
	{
		try
		{
			Map<java.lang.String, Object> params = new HashMap<java.lang.String, Object>();
			params.put("OpenID", _openID);
			params.put("EnvironmentID", _environmentID);
			params.put("EnvironmentPassword", _environmentPassword);
			java.util.List<IMendixObject> objs = Core.execute(context, "PermissionsAPI.GetRolesForOpenID", params);
			java.util.List<permissionsapi.proxies.AppRole> result = null;
			if (objs != null)
			{
				result = new java.util.ArrayList<permissionsapi.proxies.AppRole>();
				for (IMendixObject obj : objs)
					result.add(permissionsapi.proxies.AppRole.initialize(context, obj));
			}
			return result;
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
}