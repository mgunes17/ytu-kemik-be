package org.ytu.kemik.data.label.domain.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ytu.kemik.data.label.dao.entity.LabelInfo;
import org.ytu.kemik.data.label.dao.entity.LabeledSimpleData;
import org.ytu.kemik.data.label.dao.repository.LabelInfoRepository;
import org.ytu.kemik.data.label.dao.repository.LabeledSimpleDataRepository;
import org.ytu.kemik.data.label.domain.dto.LabeledTweetDTO;
import org.ytu.kemik.data.label.web.request.TweetLabelRequest;

@Service
@Transactional
public class LabelTweetServiceImpl implements LabelTweetService {

	@Autowired
	private LabelInfoRepository labelInfoRepository;

	@Autowired
	private LabeledSimpleDataRepository simpleDataRepository;

	@Override
	public void labelTweets(TweetLabelRequest request) {
		Date createdDate = new Date();

		for (LabeledTweetDTO labeled : request.getLabeledTweetDTOList()) {
			Optional<LabeledSimpleData> optionalSimpleData = simpleDataRepository.findById(labeled.getSimpleDataId());

			if (optionalSimpleData.isPresent()) {
				LabeledSimpleData simpleData = optionalSimpleData.get();

				LabelInfo info = new LabelInfo();
				info.setLabeledSimpleData(simpleData);
				info.setLabel(labeled.getLabelType().toString());
				info.setDataCreatedDate(createdDate);
				info.setUsername(request.getUsername());

				labelInfoRepository.save(info);

				if (simpleData.getLabel() == null || simpleData.getLabel().isEmpty()) {
					simpleData.setLabel(labeled.getLabelType().toString());
					simpleData.setCertain(false);
					simpleData.setLabeledDate(createdDate);

					simpleDataRepository.save(simpleData);
				}

			}
		}

	}

}
