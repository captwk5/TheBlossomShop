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

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initView()
        bindingViewModel()
        listener()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initView(){
        thumbNailAdapter = ThumbNailAdapter(this)
        viewBinding.thumbnailList.adapter = thumbNailAdapter
        thumbNailAdapter.notifyDataSetChanged()
    }

    private fun bindingViewModel(){
        viewModel.apply {
            loadDatas()

            dataLoader.observe(this@MainActivity){
                thumbNailAdapter.datas = it
            }
        }
    }

    private fun listener(){
        thumbNailAdapter.setListener(object : ThumbNailAdapter.ThumbNailClickListener{
            override fun onClick(view: View, item: ThumbNail, position: Int) {
                CoroutineScope(Dispatchers.Main).launch {
                    Toast.makeText(this@MainActivity, item.description + "-$position", Toast.LENGTH_SHORT).show()
                    val fragmentTransaction = supportFragmentManager.beginTransaction()
                    fragmentTransaction.add(viewBinding.fragmentContainer.id, BlossomFragment())
                    fragmentTransaction.commit()
                }
            }
        })
    }
}