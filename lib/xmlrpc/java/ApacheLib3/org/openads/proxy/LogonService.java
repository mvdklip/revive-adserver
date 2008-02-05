/*
+---------------------------------------------------------------------------+
| Openads v2.5                                                              |
| ============                                                              |
|                                                                           |
| Copyright (c) 2003-2008 m3 Media Services Ltd                             |
| For contact details, see: http://www.openads.org/                         |
|                                                                           |
| This program is free software; you can redistribute it and/or modify      |
| it under the terms of the GNU General Public License as published by      |
| the Free Software Foundation; either version 2 of the License, or         |
| (at your option) any later version.                                       |
|                                                                           |
| This program is distributed in the hope that it will be useful,           |
| but WITHOUT ANY WARRANTY; without even the implied warranty of            |
| MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the             |
| GNU General Public License for more details.                              |
|                                                                           |
| You should have received a copy of the GNU General Public License         |
| along with this program; if not, write to the Free Software               |
| Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA |
+---------------------------------------------------------------------------+
| Copyright (c) 2003-2008 m3 Media Services Ltd                             |
|                                                                           |
|  Licensed under the Apache License, Version 2.0 (the "License");          |
|  you may not use this file except in compliance with the License.         |
|  You may obtain a copy of the License at                                  |
|                                                                           |
|    http://www.apache.org/licenses/LICENSE-2.0                             |
|                                                                           |
|  Unless required by applicable law or agreed to in writing, software      |
|  distributed under the License is distributed on an "AS IS" BASIS,        |
|  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. |
|  See the License for the specific language governing permissions and      |
|  limitations under the License.                                           |
+---------------------------------------------------------------------------+
$Id:$
 */
package org.openads.proxy;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;

/**
 * The Class LogonService.
 * 
 * @author     Andriy Petlyovanyy <apetlyovanyy@lohika.com>
 */
public class LogonService extends AbstractService {
	private static final String LOGON_SERVICE = "LogonXmlRpcService.php";

	private static final String LOGON_METHOD = "logon";
	private static final String LOGOFF_METHOD = "logoff";

	/**
	 * Instantiates a new logon service.
	 * 
	 * @param client the client
	 * @param basepath the basepath
	 */
	public LogonService(XmlRpcClient client, String basepath) {
		super(client, basepath);
	}

	/* (non-Javadoc)
	 * @see org.openads.proxy.AbstractService#getService()
	 */
	@Override
	String getService() {
		return LOGON_SERVICE;
	}

	/**
	 * Logon.
	 * 
	 * @param username the username
	 * @param password the password
	 * 
	 * @return the string
	 * 
	 * @throws XmlRpcException the xml rpc exception
	 */
	public String logon(String username, String password) throws XmlRpcException {
		return (String) executeWithoutSessionId(LOGON_METHOD, username,
				password);
	}

	/**
	 * Logoff.
	 * 
	 * @return the boolean
	 * 
	 * @throws XmlRpcException the xml rpc exception
	 */
	public Boolean logoff() throws XmlRpcException {
		return (Boolean) execute(LOGOFF_METHOD);
	}

}
