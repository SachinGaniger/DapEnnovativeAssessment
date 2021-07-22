package com.sachin.dapennovativeassessment.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sachin.dapennovativeassessment.databinding.SingleUserLayoutBinding
import com.sachin.dapennovativeassessment.db.User

class UserListAdapter(
    private var users: List<User>,
    private val clickListener: (User, String) -> Unit
    ): RecyclerView.Adapter<UserListAdapter.ViewHolder>() {


    inner class ViewHolder(private val holderBinding: SingleUserLayoutBinding): RecyclerView.ViewHolder(holderBinding.root) {
        fun bind(user: User,position: Int, clickListener: (User, String) -> Unit){
            holderBinding.apply {
                tvName.text = user.name
                tvDob.text = user.dob
                tvLocation.text = user.location

                btDelete.setOnClickListener {
                    clickListener(user, "delete")
                    users.drop(position)
                    notifyItemRemoved(position)
//                    notifyDataSetChanged()
                }

                btEdit.setOnClickListener {
                    clickListener(user, "edit")
                }

            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListAdapter.ViewHolder {
        val view = SingleUserLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: UserListAdapter.ViewHolder, position: Int) {
        var user = users[position]
        holder.bind(user,position, clickListener)
        holder.itemView
        clickListener
    }

    override fun getItemCount(): Int {
        return users.size
    }
}