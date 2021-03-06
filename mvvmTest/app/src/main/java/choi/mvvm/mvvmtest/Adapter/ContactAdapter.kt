package choi.mvvm.mvvmtest.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import choi.mvvm.mvvmtest.R
import choi.mvvm.mvvmtest.data.Contact
import choi.mvvm.mvvmtest.databinding.ItemContactBinding

class ContactAdapter(val contactItemClick: (Contact) -> Unit, val contactItemLongClick: (Contact) -> Unit)
    : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>(){

    private var contacts: List<Contact> = listOf()

    class ContactViewHolder(val binding: ItemContactBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        val viewHolder = ContactViewHolder(ItemContactBinding.bind(view))
        view.setOnClickListener {
            contactItemClick.invoke(contacts[viewHolder.adapterPosition])
        }

        view.setOnLongClickListener {
            contactItemLongClick(contacts[viewHolder.adapterPosition])
            true
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.binding.contactData = contacts[position]
    }

    fun setContacts(contacts: List<Contact>) {
        this.contacts = contacts
        notifyDataSetChanged()
    }

}

//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import choi.mvvm.mvvmtest.R
//import choi.mvvm.mvvmtest.data.Contact
//
//
//class ContactAdapter(val contactItemClick: (Contact) -> Unit, val contactItemLongClick: (Contact) -> Unit)
//    : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
//    private var contacts: List<Contact> = listOf()
//
//    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return contacts.size
//    }
//
//    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
//        viewHolder.bind(contacts[position])
//    }
//
//    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
//        private val nameTv = itemView.findViewById<TextView>(R.id.item_tv_name)
//        private val numberTv = itemView.findViewById<TextView>(R.id.item_tv_number)
//        private val initialTv = itemView.findViewById<TextView>(R.id.item_tv_initial)
//
//        fun bind(contact: Contact) {
//            nameTv.text = contact.name
//            numberTv.text = contact.number
//            initialTv.text = contact.initial.toString()
//
//            itemView.setOnClickListener {
//                contactItemClick(contact)
//            }
//
//            itemView.setOnLongClickListener {
//                contactItemLongClick(contact)
//                true
//            }
//        }
//    }
//
//    fun setContacts(contacts: List<Contact>) {
//        this.contacts = contacts
//        notifyDataSetChanged()
//    }
//
//}