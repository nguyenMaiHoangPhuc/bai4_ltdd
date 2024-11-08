    package vn.edu.tdc.hoangphuc_bai4
    
    import android.os.Bundle
    import android.widget.Button
    import android.widget.EditText
    import android.widget.TextView
    import androidx.activity.enableEdgeToEdge
    import androidx.appcompat.app.AppCompatActivity
    import androidx.core.view.ViewCompat
    import androidx.core.view.WindowInsetsCompat
    
    class MainActivity : AppCompatActivity() {
        private lateinit var edtNhapA: EditText
        private lateinit var edtNhapB: EditText
        private lateinit var edtNhapC: EditText
        private lateinit var btnKetqua: Button
        private lateinit var tvKetqua: TextView
    
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_main)
    
            setControl()
            setEvent()
    
        }
        private fun setControl(){
            edtNhapA = findViewById(R.id.edtNhapA)
            edtNhapB = findViewById(R.id.edtNhapB)
            edtNhapC = findViewById(R.id.edtNhapC)
            btnKetqua = findViewById(R.id.btnKetqua)
            tvKetqua = findViewById(R.id.tvKetqua)
    
        }
        private fun setEvent(){
            btnKetqua.setOnClickListener{
                PhepTinh()
            }
    
        }
        private fun PhepTinh(){
            val num1 = edtNhapA.text.toString().toDoubleOrNull()
            val num2 = edtNhapB.text.toString().toDoubleOrNull()
            val num3 = edtNhapC.text.toString().toDoubleOrNull()
    
            if(num1 == null || num2 == null || num3 == null){
                tvKetqua.text = "vui lòng nhập số thích hợp"
                return
            }
            val delta = num2 * num2 - 4 * num1 * num3
            when{
                num1 == 0.0 ->{
                    if(num2 == 0.0){
                        tvKetqua.text = "Phương trinh vô nghiệm"
                    }
                    else{
                        val x = -num3/num2
                        tvKetqua.text = "Phương trình có mot nghiệm: x = $x"
                    }
                }
                delta > 0 ->{
                    val x1 = (-num2 + Math.sqrt(delta))/(2 * num1)
                    val x2 = (-num2 - Math.sqrt(delta))/(2 * num1)
                    tvKetqua.text = "PHương trình có 2 nghiệm phân biệt: x1 = $x1, x2 = $x2"
                }
                delta == 0.0 ->{
                    val x = -num2 / (2 * num1)
                    tvKetqua.text = "Phương trình có nghiệm kép x = $x"
                }
                else ->{
                    tvKetqua.text = "Phương trình không có nghiệm thực."
                }
    
            }
        }
    }