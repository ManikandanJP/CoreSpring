package com.tsi.advisor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.tsi.beans.Account;
import com.tsi.beans.Cheque;

public class ChequeClearanceMethod implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		
		Object[] params = mi.getArguments();
		Account acc = (Account) params[0];
        Cheque cheque = (Cheque) params[1];
        System.out.println("Hello " + acc.getAcc_Holder_Name() + "!,Cheque No " + cheque.getCheque_No() + " is coming for Clearance with an Amount :" + cheque.getAmount());
        mi.proceed();
        System.out.println("After Execusting Biz method");
        System.out.println("Hello "+ acc.getAcc_Holder_Name()+ "! ,Account No : " + acc.getAccno()  + " has been debited amont " + cheque.getAmount() + " in clerance of the Cheque no " + cheque.getCheque_No() + ", Now the Total amount in our account is " + acc.getBalance());
		return null;
	}

}
