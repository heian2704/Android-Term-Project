package com.example.toway.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import androidx.recyclerview.widget.RecyclerView
import com.example.toway.databinding.OrderListItemBinding
import com.example.toway.models.Order

class OrderListAdapter(private val orders: List<Order>) :
    RecyclerView.Adapter<OrderListAdapter.OrderListViewHolder>() {

    class OrderListViewHolder(val view: OrderListItemBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderListViewHolder {
        val binding =
            OrderListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return OrderListViewHolder(binding)
    }

    override fun getItemCount(): Int = orders.size

    override fun onBindViewHolder(holder: OrderListViewHolder, position: Int) {
        val order = orders[position]

        holder.view.tvCustomerName.text = order.customerName
        holder.view.tvLocation.text = order.location
        holder.view.tvOrderProblem.text = order.problem
        holder.view.tvPlateNumber.text = order.plateNumber
        holder.view.ivImage.load(order.image)
    }
}
