package com.example.noteappwithroom.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.noteappwithroom.databinding.NoteLayoutBinding
import com.example.noteappwithroom.models.Note
import com.example.noteappwithroom.views.fragments.HomeFragmentDirections

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(val binding: NoteLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id && oldItem.noteTitle == newItem.noteTitle && oldItem.noteDesc == newItem.noteDesc
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            NoteLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = differ.currentList[position]

        holder.binding.noteTitle.text = note.noteTitle
        holder.binding.noteDesc.text = note.noteDesc

        holder.itemView.setOnClickListener {
            val directions = HomeFragmentDirections.actionHomeFragmentToEditNoteFragment(note)
            it.findNavController().navigate(directions)
            //            it.findNavController().navigate(R.id.action_homeFragment_to_editNoteFragment)
        }
    }
}