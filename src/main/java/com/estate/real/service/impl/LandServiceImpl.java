package com.estate.real.service.impl;

import com.estate.real.Repository.inf.LandRepository;
import com.estate.real.document.Land;
import com.estate.real.model.request.LandRequest;
import com.estate.real.model.response.GeneralResponse;
import com.estate.real.service.inf.LandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LandServiceImpl implements LandService {

    @Autowired
    LandRepository landRepository;

    @Override
    public GeneralResponse addLand(LandRequest request) {
        Land land = new Land();
        land.setAddressSeller(request.getAddressSeller());
        land.setDistrict(request.getDistrict());
        land.setImage(request.getImage());
        land.setPrice(request.getPrice());
        land.setStreet(request.getStreet());

        landRepository.save(land);
        return new GeneralResponse(true);
    }
}
