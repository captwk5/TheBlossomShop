package com.wksy.theblossomshop

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.wksy.theblossomshop.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    private lateinit var viewBinding: ActivityMainBinding

    private lateinit var thumbNailAdapter: ThumbNailAdapter

    var datas = mutableListOf<ThumbNail>()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        thumbNailAdapter = ThumbNailAdapter(this)
        viewBinding.thumbnailList.adapter = thumbNailAdapter

        datas.add(ThumbNail("test1"))
        datas.add(ThumbNail("test2"))
        datas.add(ThumbNail("test3"))
        thumbNailAdapter.datas = datas
        thumbNailAdapter.setListener(object : ThumbNailAdapter.ThumbNailClickListener{
            override fun onClick(view: View, item: ThumbNail, position: Int) {
                CoroutineScope(Dispatchers.Main).launch {
                    Toast.makeText(this@MainActivity, item.description + "-$position", Toast.LENGTH_SHORT).show()
                }
            }
        })

        thumbNailAdapter.notifyDataSetChanged()
    }
}