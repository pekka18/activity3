package com.dignos.activity3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dignos.activity3.adapters.PersonAdapter
import com.dignos.activity3.databinding.ActivityHomeBinding
import com.dignos.activity3.models.Person

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.settings.setOnClickListener {
            val intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }

        val persons: MutableList<Person> = ArrayList()
        for (i in 1..20) { // Loop 10 times to make the list longer.
            persons.add(Person(0 + i, "Jade Russell", "Jade@gmail.com", "I am writing to inform you that I will be resigning from my position as Executive Secretary at Company Name effective four days from today, Friday, September 19, 2014. I regret to have to provide such a short notice resignation; however, personal circumstances beyond my control require me to leave my employment rather immediately. I truly regret any inconvenience my lack of notice may cause you or my coworkers and will work hard to ensure that my exit is as smooth as possible."))
            persons.add(Person(1 + i, "Angelo Telamo", "Gelo@gmail.om", "I have already informed my immediate co-workers and supervisor of my intention to leave at the end of this week. I will complete the remaining projects on which I am currently working, and my other duties will likely be taken over by the remaining secretarial staff until a replacement is hired for my position. Please contact me by phone at 000-000-0000 or through email at email@email.com if you need to discuss any issues with me."))
            persons.add(Person(2 + i, "Jm Planteras", "JmChuy@gmail.com", "I have enjoyed my time here at Company Name and have learned a great deal. Thank you to you and the staff for creating such a positive work environment. I wish you all well."))
            persons.add(Person(3 + i, "Wally Dignos", "wally@gmail.com", "A resignation letter is a formal notice to the employer to announce the intent to leave the current position held by you. Almost all companies have a formal protocol to provide a formal resignation letter before leaving the company."))
        }
        binding.personList.layoutManager = LinearLayoutManager(this)
        binding.personList.adapter = PersonAdapter(
            this, // Adding this parameter since we need the context of the current screen.
            persons
        )

    }
}