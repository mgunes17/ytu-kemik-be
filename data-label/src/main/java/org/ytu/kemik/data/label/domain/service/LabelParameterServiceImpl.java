package org.ytu.kemik.data.label.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.ytu.kemik.data.label.domain.dto.SentimentLabelType;

@Service
public class LabelParameterServiceImpl implements LabelParameterService {

	@Override
	public List<String> getLabelList(String labelCode) { // TODO dynamic by project
		if (labelCode.equals("havadis")) {
			List<String> labelTypeList = new ArrayList<>();

			labelTypeList.add(SentimentLabelType.POSITIVE.toString());
			labelTypeList.add(SentimentLabelType.NEGATIVE.toString());
			labelTypeList.add(SentimentLabelType.NOTR.toString());
			labelTypeList.add(SentimentLabelType.FREE.toString());
			labelTypeList.add(SentimentLabelType.BOT.toString());

			return labelTypeList;
		} else {
			throw new IllegalArgumentException();
		}

	}

}
