// console.log("test")
//usage of express framework & implementation of routes in nodes
// npm i express --- npmjs.com

/*
var express = require('express'); // express will be exported from node_module

// console.log(typeof express);

var app = express();

// console.log(app);

// routes?????

//<a href="about.html">About us</a>

app.get("/aboutus" , function(req,res){
    // document.write("test");
    res.send("about us page");
});

//transfer form data from html page to server side in node (req)
// res - serverside to browser

app.listen(4000,"localhost");

*/

var express = require('express'); //node_module
// console.log(typeof express);
var app = express();
// console.log(app);

// integrate or register any template engine
//https://expressjs.com/en/guide/using-template-engines.html
app.set('view engine','ejs'); //all ejs files are expected from views folder

// localhost:4000/
app.get("/" ,function(req, res){
    res.send("<h1> Home Page </h1>")
});

// localhost:4000/contactus
app.get("/contactus" , function(req,res){
    res.send("<u> Hello World </u>");
});
app.get("/missionData" , function(req,res){
    res.send("<u> mission page </u>");
});

app.get("/aboutus",function(req,res){
    res.render("indexPage");
})

app.listen(4000 , "localhost" , function(){
    console.log('server running')
});



















