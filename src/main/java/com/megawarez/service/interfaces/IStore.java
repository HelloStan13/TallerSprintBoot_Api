package com.megawarez.service.interfaces;

import com.megawarez.domain.Category;
import com.megawarez.domain.Download;
import com.megawarez.domain.Item;
import com.megawarez.domain.SubCategory;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IStore {

    public List<Category> getCategories();

    public List<Category> searchCategory(String dataToSearch);

    public Category createCategory(Category category);

    Category updateName(Integer id, Category category);

    Category deleteCategory(Integer id);

    public List<SubCategory> getSubCategories();

    public List<SubCategory> searchSubCategory(String dataToSearch);

    public SubCategory createSubCategory(SubCategory subCategory);

    SubCategory updateName(Integer id, SubCategory subCategory);

    SubCategory deleteSubCategory(Integer id);

    public List<Item> getItems();

    public List<Item> getItemOrder(String field, Sort.Direction order);

    public Item createItem(Item item);

    Item updateName(Integer id, Item item);

    Item deleteItem(Integer id);

    Download logDownload(Integer userId, Integer itemId);

    public List<Download> getDownloads();
}
