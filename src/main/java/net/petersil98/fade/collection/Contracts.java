package net.petersil98.fade.collection;

import net.petersil98.fade.data.Contract;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Contracts {

    private static Map<String, Contract> contracts;

    public static Contract getContract(String id) {
        return contracts.get(id);
    }

    public static <T> List<Contract> getContractsOfType(Contract.ContentType<T> type) {
        return getContracts().stream().filter(contract -> contract.getContent().getContentType().equals(type)).toList();
    }

    public static List<Contract> getContracts() {
        return new ArrayList<>(contracts.values());
    }
}
