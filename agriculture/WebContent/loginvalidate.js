/**
 * 
 */
function validate()
{ 
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var password = document.getElementById("usertype").value;
        
     if (username==null || username=="")
     { 
     alert("Username cannot be blank"); 
     return false; 
     }
     else if(password==null || password=="")
     { 
     alert("Password cannot be blank"); 
     return false; 
     } 
      else if(usertype==null || usertype=="")
     { 
     alert("select a usertype "); 
     return false; 
     } 
}