function load(str)
{
  var xmlhttp;

  if (window.XMLHttpRequest)
  {
    xmlhttp=new XMLHttpRequest();
  }
  else
  {
    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
  xmlhttp.onreadystatechange=function()
  {
    if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
      var or = (document.getElementById("result").innerHTML=xmlhttp.responseText);
      document.getElementById("result").value=or;
    }
  }
    xmlhttp.open("POST","JSelector",true);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("q="+str);
}