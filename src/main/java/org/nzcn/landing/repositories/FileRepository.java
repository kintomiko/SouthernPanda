package org.nzcn.landing.repositories;

import org.nzcn.landing.models.FileEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kinlin on 9/7/16.
 */
public interface FileRepository extends CrudRepository<FileEntity, String>, JpaSpecificationExecutor<FileEntity> {
}
