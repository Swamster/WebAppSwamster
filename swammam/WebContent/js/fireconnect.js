/**
 * 
 */

//function fromServlet (num1, num2){
////	var request = new XMLHttpRequest();
////	request.open('POST', "http://localhost:8080/swammam/Swamster", true);
////
////	request.setRequestHeader("Content-type", "http://localhost:8080/swammam/Swamster")
//	
////	request.send("num1");
////	request.send("num2");
////	var form1 = document.getElementById("num1").innerHTML
////	var form2 = document.getElementById("num2").innerHTML
//	
////	num11= num1.toString();
////	num22=num2.toString();
////	
////	request.send(num11);
////	request.send(num22);
////	
//	
////	var var1= document.getElementById('num1');
////	var var2= document.getElementById('num2');
////	num1.push(var1.value);
////	num2.push(var2.value);
//	
//	return num1+num2;
//	
//
//	
//}

//function firebase (message){
	var firebase = require("firebase");
	
	 var config = {
			    apiKey: "AIzaSyAJIorYfyXdhQ9THqnJsXp4rjGIjxcS1ds",
			    authDomain: "swamsteras.firebaseapp.com",
			    databaseURL: "https://swamsteras.firebaseio.com",
			    projectId: "swamsteras",
			    storageBucket: "swamsteras.appspot.com",
			    messagingSenderId: "824450759757"
			  };
			  firebase.initializeApp(config);
	
			  
	function workplz(message){ 
	var messagestring= message.toString();
	var database = firebase.database();
	firebase.database().ref('server').set(messagestring);
	
}