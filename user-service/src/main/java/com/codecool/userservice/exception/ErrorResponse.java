package com.codecool.userservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@AllArgsConstructor
@XmlRootElement(name = "error")
@Data
public class ErrorResponse {

    private List<String> details;
}
