var xmlRequest;
function createXmlRequest() {
	try {
		xmlRequest = new XMLHttpRequest();
	}
	catch (re) {
		xmlRequest = new ActiveXObjcet("Microsoft.XMLHTTP");
	}
}

