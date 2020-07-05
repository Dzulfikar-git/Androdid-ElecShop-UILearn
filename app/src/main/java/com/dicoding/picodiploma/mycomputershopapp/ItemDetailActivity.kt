package com.dicoding.picodiploma.mycomputershopapp

import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide

class ItemDetailActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_PRICE = "extra_price"
        const val EXTRA_IMG = "extra_image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)

        val btnAddCount : ImageButton = findViewById(R.id.id_btn_add)
        val btnMinCount : ImageButton = findViewById(R.id.id_btn_min)
        val btnBuyItem : Button = findViewById(R.id.id_btn_buy)
        val btnAddCart : Button = findViewById(R.id.id_btn_addcart)
        val btnFavorite : Button = findViewById(R.id.id_btn_favorite)
        val btnAddReview : Button = findViewById(R.id.id_btn_addreview)

        btnAddCount.setOnClickListener(this)
        btnMinCount.setOnClickListener(this)
        btnBuyItem.setOnClickListener(this)
        btnAddCart.setOnClickListener(this)
        btnFavorite.setOnClickListener(this)
        btnAddReview.setOnClickListener(this)

        val name = intent.getStringExtra(EXTRA_NAME)
        val detail = intent.getStringExtra(EXTRA_DETAIL)
        val price = intent.getStringExtra(EXTRA_PRICE)
        val img = intent.getIntExtra(EXTRA_IMG, 0)

        setTitle(name)

        val itemName : TextView = findViewById(R.id.id_itemdetail_name)
        val itemPrice : TextView = findViewById(R.id.id_itemdetail_price)
        val itemDetail : TextView = findViewById(R.id.id_itemdetail_detail)
        val itemImg : ImageView = findViewById(R.id.id_itemdetail_img)


        itemName.text = name
        itemDetail.text = detail
        itemPrice.text = "Rp $price"
        itemImg.setImageResource(img)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.id_btn_add -> {
                setCount("add")
            }

            R.id.id_btn_min -> {
                setCount("min")
            }

            R.id.id_btn_buy -> {
                Toast.makeText(this, "You Have Bought " + intent.getStringExtra(EXTRA_NAME), Toast.LENGTH_SHORT).show()
            }

            R.id.id_btn_addcart -> {
                Toast.makeText(this, "You Have Added " + intent.getStringExtra(EXTRA_NAME) + " to Cart", Toast.LENGTH_SHORT).show()
            }

            R.id.id_btn_favorite -> {
                Toast.makeText(this, "You Have Added " + intent.getStringExtra(EXTRA_NAME) + " to Favorite", Toast.LENGTH_SHORT).show()
            }

            R.id.id_btn_addreview -> {
                addReview()
            }
        }
    }

    fun setCount(action : String) {
        val count : EditText = findViewById(R.id.id_text_itemcount)
        val number = count.getText().toString()
        var calc : Int = Integer.parseInt(number)

        if(action == "add") {
            calc = calc + 1
        } else {
            calc = calc - 1
        }
        count.setText(calc.toString())
    }

    fun addReview() {
        val review : EditText = findViewById(R.id.id_text_review)
        val reviewText = review.text.toString()

        if(reviewText == ""){
            return
        } else {
            Toast.makeText(this, "You Have Added '" + reviewText + "' to The Review", Toast.LENGTH_LONG ).show()
            review.setText("")
        }

    }

}