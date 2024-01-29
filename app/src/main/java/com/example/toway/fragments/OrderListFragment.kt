package com.example.toway.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toway.OrderList
import com.example.toway.adapters.OrderListAdapter
import com.example.toway.databinding.FragmentListBinding

class OrderListFragment : Fragment() {
    private lateinit var view: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = FragmentListBinding.inflate(inflater, container, false)

        view.rvList.adapter = OrderListAdapter(OrderList.orders)
        view.rvList.layoutManager = LinearLayoutManager(context)

        return view.root
    }
}