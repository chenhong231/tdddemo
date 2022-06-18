package org.samples;

import org.approvaltests.core.ApprovalFailureReporter;
import org.approvaltests.reporters.DiffReporter;

public class PackageSettings {

    public ApprovalFailureReporter UseReporter = DiffReporter.INSTANCE;
}
