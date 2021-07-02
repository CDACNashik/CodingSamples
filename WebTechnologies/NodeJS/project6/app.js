require('dotenv').config();
var validator = require('validator');
const nodemailer = require("nodemailer");
const db = require('monk')(process.env.MONGO_PATH);
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
app.use(bodyParser.urlencoded({ extended: true }));
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

app.post("/form-action-mongo" , function(req,res){
    // res.send({msg:"Route Called"}); 
    //username=test&userage=20
    //{username:"test",userage:20,useremail:'a@s.com'}
    console.log(req.body); //undefined

    //validation using node + validator

    //username must be npn empty - 2,20 , alpha

    if( validator.isEmpty(req.body.username) || !validator.isAlpha(req.body.username,'en-IN') || !validator.isLength(req.body.username,{min:2,max:100}) ){
        res.send({errmsg:"Invalid UserName"});
    }

    else if(validator.isEmpty(req.body.userage) || !validator.isInt(req.body.userage)){
        res.send({errmsg:"Invalid UserAge"});
    }

    else if(validator.isEmpty(req.body.useremail) || !validator.isEmail(req.body.useremail)){
        res.send({errmsg:"Invalid Emailid"})
    }
    else{
        // console.log(req.body);
        db.get("users").insert({name:req.body.username,age:req.body.userage,email:req.body.useremail}).then(function(results){
            if(results){
                console.log(results);
                //Do Email send welcome message to users
                main(req.body.useremail , "Test Subscribe" ,"<b> Your are successfully registered with us </b>").catch(console.error);
                //
                res.send({errmsg:"Record Added  in DB"});
            }
        })
        
    }

     
})


async function main(toEmailid,subjectForEmail,mesForEmail) {
    // Generate test SMTP service account from ethereal.email
    // Only needed if you don't have a real mail account for testing
    let testAccount = await nodemailer.createTestAccount();
  
    // create reusable transporter object using the default SMTP transport
    let transporter = nodemailer.createTransport({
      host: process.env.HOSTNAME,
    //   host: "smtp.gmail.com",
      port: 587,
      secure: false, // true for 465, false for other ports
      auth: {
        user: process.env.EMAIL, // generated ethereal user
        // user: "original emailid", // generated ethereal user
        pass: process.env.PASS, // generated ethereal password
        // pass: "passs for gmail", // generated ethereal password
      },
      tls:{
        rejectUnauthorized: false
      },
      name :"php-training.in"  
    });
  
    // send mail with defined transport object
    let info = await transporter.sendMail({
      from: '<suraj@php-training.in>', // sender address
    //   from: '<your gmailid>', // sender address
      to: toEmailid, // list of receivers
      subject: subjectForEmail, // Subject line
      text: "Hello world?", // plain text body
      html: mesForEmail, // html body
    });
  
    console.log("Message sent: %s", info.messageId);
    // Message sent: <b658f8ca-6296-ccf4-8306-87d57a0b4321@example.com>
  
    // Preview only available when sending through an Ethereal account
    console.log("Preview URL: %s", nodemailer.getTestMessageUrl(info));
    // Preview URL: https://ethereal.email/message/WaQKMgKddxQDoou...
  }


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



/*
    after registartion - send a mail - welcome message
    forgot pass - OTP on Mobile or Email
    after registartion - send a verification link on email
    change pass - send a message confirmation
    add to cart - payment successful - you must send a mail to customers
*/

/*
    development server-- (.env) 
    staging -- (developers & clients) (.env) 
    Live mode --- (end users) (.env) 

    file upload ( image )
    payment gateway ()
    OTP
        forgot  pass FORM - 
        send email - 
        check email in db - 
        if email exist - 
        create OTP (Random No ) - 
        send otp to email & update ur database with OTP-
        check OTP - from email with DB
        change password - current email
*/