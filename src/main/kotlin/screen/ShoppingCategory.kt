package screen

import extensions.getNotEmptyString

class ShoppingCategory : Screen() {
     fun showCategories() {
        ScreenStack.push(this)
        val categories = arrayOf("패션", "전자기기", "반려동물용품")
        for (category in categories) {
            println(category)
        }
        println("-> 장바구니로 이동하시려면 #을 입력해주세요")

        val selectedCategory = readLine().getNotEmptyString()
        if (selectedCategory == "#") {
            val shoppingCart = ShoppingCart()
            shoppingCart.showCartItems()
        } else {
            if (categories.contains(selectedCategory)) {
                val shoppingProductList = ShoppingProductList(selectedCategory)
                shoppingProductList.showProducts()
            } else {
                showErrorMessage(selectedCategory)
            }
        }
    }

    private fun showErrorMessage(selectedCategory: String?) {
        println("[$selectedCategory] : 존재하지 않는 카테고리 입니다. 다시 입력해주세요.")
        showCategories() // 사용자가 카테고리 목록에 없는 값을 입력했으니 다시 입력을 요청하는것이 사용자 친화적인 ux
    }
}