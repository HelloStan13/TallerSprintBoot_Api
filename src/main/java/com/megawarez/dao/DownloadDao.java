package com.megawarez.dao;

import com.megawarez.domain.Download;
import org.springframework.data.repository.CrudRepository;

public interface DownloadDao extends CrudRepository<Download, Integer> {
}