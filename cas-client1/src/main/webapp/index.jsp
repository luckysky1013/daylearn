<%@ page import="org.jasig.cas.client.authentication.AttributePrincipal" %>
<%@ page import="java.util.Map" %>
<html>
<body>
<h2>CAS Client 1</h2>
</body>
<%
    AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();

    Map attributes = principal.getAttributes();

    String email= (String) attributes .get("usruid");
    out.print(email);
%>
</html>
