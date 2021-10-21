package com.example.menus

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import androidx.annotation.MenuRes
import androidx.databinding.DataBindingUtil
import com.example.menus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),View.OnClickListener {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding?.popup?.setOnClickListener(this)

    }


    // При нажатии на кнопку показываем Попап Меню
    override fun onClick(view: View) {
        showMenu(view, R.menu.menu_popup)
    }

    // Создаем всплывающее меню (Саму карточку)
    @SuppressLint("RestrictedApi")
    private fun showMenu(view: View, @MenuRes menuRes: Int) {
        val popup = PopupMenu(this, view)
        popup.menuInflater.inflate(menuRes, popup.menu)

        // Метод нажатий на пункты Попап Меню
        popup.setOnMenuItemClickListener { menuItem: MenuItem ->
            when(menuItem.itemId) {

                R.id.catalogMenuTwo -> {
                    binding?.selectedItem?.text = getString(R.string.catalog)

                    true}

                R.id.favoritesMenuTwo -> {
                    binding?.selectedItem?.text = getString(R.string.favorites)

                    true}

                R.id.accountMenuTwo -> {
                    binding?.selectedItem?.text = getString(R.string.account)

                    true}

                else -> false
            }
        }
        // Метод при закрытии всплываюшего окна
        popup.setOnDismissListener {
            binding?.condition?.text = getString(R.string.closed)
        }

        popup.show()
    }

}