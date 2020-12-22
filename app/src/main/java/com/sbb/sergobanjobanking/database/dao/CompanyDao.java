package com.sbb.sergobanjobanking.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.sbb.sergobanjobanking.database.entities.CompanyModel;

@Dao
public interface CompanyDao {

    @Query("SELECT COUNT(*) FROM companies")
    long getCount();

    @Query("SELECT * FROM companies ORDER BY caption")
    CompanyModel[] getAll();

    @Query("SELECT * FROM companies WHERE idCompany=:idCompany")
    CompanyModel getCompany(long idCompany);

    @Insert
    long insert(CompanyModel companyModel);

    @Update
    void update(CompanyModel companyModel);

}
