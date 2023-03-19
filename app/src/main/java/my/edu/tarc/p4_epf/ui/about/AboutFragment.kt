package my.edu.tarc.p4_epf.ui.about

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import my.edu.tarc.p4_epf.databinding.FragmentAboutBinding

/* A simple [Fragment] subclass... */
class AboutFragment : Fragment() {
    private var _binding : FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // [Button Web]
        binding.buttonWeb.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.kwsp.gov.my")
            startActivity(intent)
        }

        // [Button Phone]
        binding.buttonPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("tel:0389226000")
            startActivity(intent)
        }

        // [Button Email]
        binding.buttonEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            with(intent) {
                data = Uri.parse("mailto:service@kwsp.gov.my")
                putExtra("subject", "Request for Service")
            }
            startActivity(intent)
        }

        // [Button Location]
        binding.buttonLocation.setOnClickListener {
            val gmmIntentUri = Uri.parse("google.streetview:cbll=46.414382,10.013988")
            val intent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            intent.setPackage("com.google.android.apps.maps")

            startActivity(intent)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}