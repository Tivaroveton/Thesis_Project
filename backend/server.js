const express = require("express")
const bodyParser = require("body-parser")

const formidable = require('formidable');
const path = require('path');
const fs = require("fs-extra");

const app = express()
app.use(bodyParser.urlencoded({extended: false}))


app.post("/uploads", (req, res)=>{
     try {
            var form = new formidable.IncomingForm();
            var date = Date.now();

            form.parse(req, function (err, fields, files) {

                console.log(JSON.stringify(files));

                var oldpath = files.userfile.path;
                var newpath = path.join(__dirname, "./uploads/" + date.toString() + "_" + files.userfile.name);

                fs.move(oldpath, newpath, function (err) {
                    if (err) throw err;

                  var username = fields.username;
                  var password = fields.password;

                  console.log("username: " + username);
                  console.log("password: " + password);

                  res.end("Upload Successfully\n" + username + " " + password);
                });
            });
        } catch (err) {
            console.log("err : " + err);
        }

})


app.get("/", (req, res)=>{
    res.end("Ok")
})

app.post("/register", (req, res)=>{
    res.json({result: "ok", detail: req.body})
})

app.get("/login", (req, res)=>{

    res.json({result: "ok", detail: req.query})
})

app.listen(3000, ()=>{
    console.log("Running...")
})