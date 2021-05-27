package ez.mus.jamendomusic

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ez.mus.jamendomusic.api.APIService
import ez.mus.jamendomusic.api.ApiHelper
import ez.mus.jamendomusic.api.MyRetrofitService
import ez.mus.jamendomusic.databinding.FragmentOnlineListBinding
import ez.mus.jamendomusic.model.Song
import ez.mus.jamendomusic.repository.Repository
import ez.mus.jamendomusic.utils.OnRvItemClickListener
import ez.mus.jamendomusic.utils.Status

class OnlineListFragment : Fragment(), OnRvItemClickListener {
    private var _binding: FragmentOnlineListBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: OnlineSongAdapter
    private lateinit var viewModel: OnlineSongViewModel
    private lateinit var service: APIService

    private lateinit var apiHelper: ApiHelper


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentOnlineListBinding.inflate(inflater, container, false)
        service = MyRetrofitService.retrofit().create(APIService::class.java)
        apiHelper = ApiHelper(service)
        adapter = OnlineSongAdapter(this)
        viewModel =
            ViewModelProvider(
                this,
                MyViewModelFactory(apiHelper)
            ).get(OnlineSongViewModel::class.java)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.onlineSongLiveData.observe(viewLifecycleOwner, {
            when (it.status) {
                Status.LOADING -> {
                    Toast.makeText(context, "Loading start...", Toast.LENGTH_SHORT).show()
                }
                Status.ERROR -> {
                    Toast.makeText(context, "Error: ${it.message}", Toast.LENGTH_SHORT).show()
                }
                Status.SUCCESS -> {
                    Toast.makeText(context, "oonSuccess", Toast.LENGTH_SHORT).show()
                    it.data?.let { it1 -> adapter.setData(it1) }
                }
            }
        })
        binding.rvOnlineListFragment.layoutManager = LinearLayoutManager(context)
        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.rvOnlineListFragment.addItemDecoration(divider)
        binding.rvOnlineListFragment.adapter = adapter
        binding.buttonFr.setOnClickListener { viewModel.requestSong("pop") }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }

    override fun onItemClick(position: Int) {
        Log.e("OnlineFR", "onItemClick ")
        viewModel.itemClick(position)
    }
}