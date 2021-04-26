<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function validate(){
	var team_name = document.f1.team_name.value;
	var status = false;
	if(team_name == ""){
		document.getElementById("nl");
        alert("Please enter your valid input");
		status = false;
	}
	else{
		document.getElementById("nl");
        alert("correct");
		status=true;
	}
	return status;
}
</script>
<form name="f1" action="delete.meg" onsubmit="return validate()">
TeamName<input type="text" name="teamName">
<input type="submit" value="submit">
</form>

</body>
</html>