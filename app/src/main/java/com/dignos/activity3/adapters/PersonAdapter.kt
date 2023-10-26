package com.dignos.activity3.adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dignos.activity3.Profile
import com.dignos.activity3.constants.Constants
import com.dignos.activity3.databinding.ItemPersonBinding
import com.dignos.activity3.models.Person

class PersonAdapter(
    private val activity: Activity,
    private val persons: MutableList<Person>
    ): RecyclerView.Adapter<PersonAdapter.PersonViewHolder>(){

        class PersonViewHolder(
            private val activity: Activity,
            private val binding: ItemPersonBinding
        ): RecyclerView.ViewHolder(binding.root){
            fun bind(person: Person){
                val title = "[${person.id}] ${person.name}"
                binding.name.text = title
                binding.email.text = person.email
                binding.message.text = person.message
                binding.row.setOnClickListener{
                    val intent = Intent(
                        activity, // Context of the Current Activity.
                        Profile::class.java // Activity that we want to open.
                    )

                    // Adding Int type parameter from current Activity to ProfileActivity.
                    intent.putExtra(Constants.PARAM_ID, person.id)

                    // Adding String type parameter from current Activity to ProfileActivity.
                    intent.putExtra(Constants.PARAM_NAME, person.name)
                    intent.putExtra(Constants.PARAM_EMAIL, person.email)
                    intent.putExtra(Constants.PARAM_MESSAGE, person.message)

                    // Open the ProfileActivity.
                    activity.startActivity(intent)
                }
            }
        }
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): PersonViewHolder {
            val binding = ItemPersonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return PersonViewHolder(activity, binding)
        }

        override fun getItemCount() = persons.size

        override fun onBindViewHolder(
            holder: PersonViewHolder,
            position: Int
        ) {
            holder.bind(persons[position])
        }
    }
