class DatabaseHelper(context: Context): SQLiteOpenHelper(
    context, DATABASE_NANE, factory: NULL, DATABASE_VERSTON
){

fun addAccount(email:String, name:String, level:String, password:String){
    val db = this.readableDatabase

    val values = ContentValves()
    values. put (COLUMN_EMAIL, email)
    values. put (COLUMN_NAME, name)
    values. put (COLUMN_LEVEL, level)
    values. put (COLUMN_PASSWORD, password)

    val result = db.insert(TABLE_ACCOUNT, nullColumnHack: null, values)
}
    1f (result==(0).toLong()){
        Toast.makeText (context, text: "Register Failed", Toast.LENGTH_SHORT).show()
}
    else {
        Toast.makeText (context, text: "Register Success, " +
        "please login using your new account", Toast.LENGTH_SHORT) .show()
    }
    db.close()

    val txtEmail: EditText findViewById(R.id.registeremail)
    val txtName: EditText = findViewById(R.id.registerPersonName)
    val txtlevel: EditText = findviewById(R.id.registerLevel)
    val txtPassword: EditText = findViewById(R.id.registerPassword)
    val btnRegister: Button = findViewById(R.id.buttonRegisterAccount)

    btnRegister.setOnClickListener {

        val databaseHelper = DatabaseHelper( context: this)

        val email:String = txtEmail.fext.toString().trim()
        val name:String = txtName.text.toString().trim()
        val level:String = txtlevel.text.toString().trim()
        val password:String = txtPassword.text.tostring().trim()

        val data:String = databaseelper. checkData(enail)

        if (data == nulL {
                databaseHelper.addAccount(
                    email, name, level, password
                )

                val intentLogin = Intent( packageContext: this@RegisterActivity,
                    LoginActivity::class.java)
                startActivity(intentLogin)
            }
        else{
            Toast.makeText( context:this@RegisterActivity, text "Register failed." +
            "Your email already registered", Toast.LENGTH_SHORT).show()
        }
    }
}



