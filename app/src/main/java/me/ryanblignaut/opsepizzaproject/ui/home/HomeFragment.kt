package me.ryanblignaut.opsepizzaproject.ui.home

import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.ShareCompat
import androidx.core.app.ShareCompat.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import me.ryanblignaut.opsepizzaproject.databinding.FragmentHomeBinding
import java.util.Date


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }


        binding.BtnImplicitIntent.setOnClickListener {

//            val downloadIntent =
//                Intent(requireContext(), Context.DOWNLOAD_SERVICE::class.java).apply {
//                    data = Uri.parse("www.google.com")
//                }
//            requireContext().startService(downloadIntent)


//            val calendarIntent = Intent(Intent.ACTION_VIEW)

//            val startMillis = System.currentTimeMillis()
//            val builder = CalendarContract.CONTENT_URI.buildUpon()
//            builder.appendPath("events")
//            ContentUris.appendId(builder, startMillis)
//            val calendarIntent = Intent(Intent.ACTION_VIEW).setData(builder.build())
//            startActivity(calendarIntent)

//            val data = Uri.parse("content://com.android.calendar/time/")
//            calendarIntent.data = data
//            println("Hello")

//            val sendIntent = Intent(Intent.ACTION_SEND)

            // Always use string resources for UI text.
            // This says something like "Share this photo with"
//            val title: String = resources.getString(R.string.app_name)
            // Create intent to show the chooser dialog
//            val chooser: Intent = Intent.createChooser(calendarIntent, title)

            // Verify the original intent will resolve to at least one activity
//            if (calendarIntent.resolveActivity(requireContext().packageManager, ) != null) {
//            startActivity(calendarIntent)
//            }



//            IntentBuilder.from(requireActivity())

            val beginTime = System.currentTimeMillis()
            val endTime = System.currentTimeMillis() + 1000 * 60 * 60 * 10

            val intent = Intent(Intent.ACTION_INSERT)
            intent.data = CalendarContract.Events.CONTENT_URI
            intent.putExtra(CalendarContract.Events.TITLE, "Hello from title")
            intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Event 123")
            intent.putExtra(CalendarContract.Events.DESCRIPTION, "Event Description diff")
            intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true)
            intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime)
            intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime)
            startActivity(intent)

        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}