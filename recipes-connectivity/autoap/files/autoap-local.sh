#!/bin/bash
# \$1 has either "Client" or "AccessPoint"
logmsg () {
    [ \$debug -eq 0 ] && logger --id=\$\$ "\$1"
}
[ -f /usr/local/bin/autoAP.conf ] && source /usr/local/bin/autoAP.conf || debug=0
case "\$1" in
    Client)
          logmsg "/usr/local/bin/autoAP-local: Client"
	  ## Add your code here that runs when the Client WiFi is enabled
	  ;;
    AccessPoint)
          logmsg "/usr/local/bin/autoAP-local: Access Point"
	  ## Add your code here that runs when the Access Point is enabled
	  ;;
