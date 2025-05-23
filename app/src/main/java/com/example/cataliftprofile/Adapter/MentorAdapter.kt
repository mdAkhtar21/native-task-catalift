package com.example.catalift.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.catalift.Modal.Mentor
import com.example.cataliftprofile.R

class MentorAdapter(private var mentors: List<Mentor>) : RecyclerView.Adapter<MentorAdapter.MentorViewHolder>() {

    inner class MentorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val experience: TextView = itemView.findViewById(R.id.experience)
        val domain: TextView = itemView.findViewById(R.id.domain)
        val reviews: TextView = itemView.findViewById(R.id.reviews)
        val image:ImageView=itemView.findViewById(R.id.profile_image)
        val rating:TextView= itemView.findViewById(R.id.rating)
        val desc: TextView = itemView.findViewById(R.id.description)
        val compatibility: TextView = itemView.findViewById(R.id.compatibility)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MentorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mentor, parent, false)
        return MentorViewHolder(view)
    }

    override fun onBindViewHolder(holder: MentorViewHolder, position: Int) {
        val mentor = mentors[position]
        holder.image.setImageResource(mentor.img)
        holder.name.text = mentor.name
        holder.rating.text=mentor.rating
        holder.experience.text = mentor.experience
        holder.domain.text = mentor.domain
        holder.reviews.text = "${mentor.reviews} Reviews"
        holder.desc.text = mentor.description
        holder.compatibility.text = "${mentor.compatibility} compatibility"
    }

    override fun getItemCount(): Int = mentors.size
    fun updateData(newList: List<Mentor>) {
        mentors = newList
        notifyDataSetChanged()
    }
}
