const db = require('monk')('localhost:27017/cdac_nashik_2021');
// console.log(db);
const bodyParser = require('body-parser');
//npm i mysql

var mysql  = require('mysql');
var connection = mysql.createConnection({
    host:"localhost",
    user:"root",
    password:"",
    database:"nodeproject"
});
// console.log(connection);

var express = require('express');

var app = express();
app.set('view engine', 'ejs');
app.use(bodyParser.urlencoded({ extended: true }))
//localhost:3000/
app.get("/" , function(req,res){
    res.render("indexPage");
});
//localhost:3000/add

app.get("/add" , function(req,res){
    res.render("addPage");
});

//localhost:3000/show

app.get("/show" , function(req,res){
    connection.query("select * from userinfo " , function(err,results){
        if(!err){
            // console.log(results)
            /*
                [
                    {userid:1,username:'rohan',useremail:'rohan@gmail.com'},
                    {userid:1,username:'rohan',useremail:'rohan@gmail.com'}
                ]
            */
            res.render('showPage' , {x:10,y:20,recordFromDb:results})
        }
        else{
            console.log(err);
        }
    });
    // res.render("showPage");
})

app.get("/contact",function(req,res){
    res.render("contactPage");
})

app.post("/form-action",function(req,res){
    // res.send({msg:"Route Exist"});
    //receive data from browser / form
    console.log(req.body); //undefined
    // {username:hhh , useremail:sss}
    //name="username"
    var sqlQuery = `insert into userinfo (username,useremail) 
    values ('${req.body.username}','${req.body.useremail}') 
    `;
    console.log(sqlQuery);


    //perform query
    connection.query(sqlQuery , function(err,results){
        if(!err){
            console.log(results);
            res.redirect("/show");
        }
        else{
            console.log(err);
        }
    })
    

});

app.get("/add_ajax",function(req,res){
    res.render("addPage_ajax");
})

app.get("/show_record_mongo",function(req,res){
    // res.send("TEST")
    db.get("users").find().then(function(results){
        // console.log(results)
        res.render("viewMongo",{recordFromDb:results})
    })
});

app.get("/deleteData/:userid/:no",function(req,res){
    console.log(req.params);
    //it will fetch all values from url in JSON object format
    var userid = req.params.userid;
    // res.send("Route EXIST");
    db.get('users').remove({ "_id": userid }).then(function(results){
        // console.log(results);
        res.redirect("/show_record_mongo");
    });
});

app.get("/add_record_mongo" , function(req,res){
    res.render("add_record_in_mongo")
})


//insert into users (info) values ('role=developer#joblocation=Pune')

//RDBMS - country , states for country

/*
    [
        {
            country:"india",
            states:[
                "maharashtra","punjab"
            ]
        },
        {
            country:"USA",
            states:[
                "CA","New York"
            ]
        }
    ]
*/

app.listen(3000,"localhost",function(){
    console.log("Server Running");
});

/*
    CREATE database nodeproject

    create table userinfo(
        userid int auto_increment primary key,
        username varchar(200),
        useremail varchar(200)
    );

    insert into userinfo (username,useremail) values ('rohan','rohan@gmail.com');
    insert into userinfo (username,useremail) values ('roshan','roshan@gmail.com');
*/



