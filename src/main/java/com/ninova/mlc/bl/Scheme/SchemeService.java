package com.ninova.mlc.bl.Scheme;

import com.ninova.mlc.vo.ResponseVO;
import org.springframework.stereotype.Repository;

@Repository
public interface SchemeService {
    ResponseVO acquireScheme(int userID);

}
