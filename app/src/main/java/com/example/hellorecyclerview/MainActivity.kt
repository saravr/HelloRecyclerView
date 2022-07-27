package com.example.hellorecyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.hellorecyclerview.databinding.ActivityMainBinding
import com.example.hellorecyclerview.databinding.ItemBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvTest.apply {
            adapter = Adapter()
        }
    }
}

private val names = Array(50) {
    "Item $it"
}

class Adapter: RecyclerView.Adapter<Adapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemBinding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(names[position])
    }

    override fun getItemCount() = names.size

    class MyViewHolder(private val itemBinding: ItemBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(name: String) {
            itemBinding.tvItemName.text = name
        }
    }
}