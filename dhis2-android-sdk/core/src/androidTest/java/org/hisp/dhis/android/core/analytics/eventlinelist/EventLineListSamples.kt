/*
 *  Copyright (c) 2004-2021, University of Oslo
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *  Redistributions of source code must retain the above copyright notice, this
 *  list of conditions and the following disclaimer.
 *
 *  Redistributions in binary form must reproduce the above copyright notice,
 *  this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 *  Neither the name of the HISP project nor the names of its contributors may
 *  be used to endorse or promote products derived from this software without
 *  specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.hisp.dhis.android.core.analytics.eventlinelist

import java.util.*
import org.hisp.dhis.android.core.arch.helpers.UidGeneratorImpl
import org.hisp.dhis.android.core.category.CategoryCombo
import org.hisp.dhis.android.core.category.CategoryOptionCombo
import org.hisp.dhis.android.core.common.AggregationType
import org.hisp.dhis.android.core.common.FormType
import org.hisp.dhis.android.core.common.ObjectWithUid
import org.hisp.dhis.android.core.common.ValueType
import org.hisp.dhis.android.core.dataelement.DataElement
import org.hisp.dhis.android.core.enrollment.Enrollment
import org.hisp.dhis.android.core.event.Event
import org.hisp.dhis.android.core.organisationunit.OrganisationUnit
import org.hisp.dhis.android.core.program.Program
import org.hisp.dhis.android.core.program.ProgramIndicator
import org.hisp.dhis.android.core.program.ProgramStage
import org.hisp.dhis.android.core.trackedentity.TrackedEntityInstance
import org.hisp.dhis.android.core.trackedentity.TrackedEntityType

object EventLineListSamples {

    val generator = UidGeneratorImpl()

    val trackedEntityType: TrackedEntityType = TrackedEntityType.builder()
        .uid(generator.generate())
        .displayName("Tracked Entity Instance")
        .build()

    val categoryCombo: CategoryCombo = CategoryCombo.builder()
        .uid(generator.generate())
        .build()

    val categoryOptionCombo: CategoryOptionCombo = CategoryOptionCombo.builder()
        .uid(generator.generate())
        .categoryCombo(ObjectWithUid.fromIdentifiable(categoryCombo))
        .build()

    val program1: Program = Program.builder()
        .uid(generator.generate())
        .displayName("Program 1")
        .trackedEntityType(trackedEntityType)
        .categoryCombo(ObjectWithUid.fromIdentifiable(categoryCombo))
        .build()

    val program1Stage1: ProgramStage = ProgramStage.builder()
        .uid(generator.generate())
        .displayName("Program 1 Stage 1")
        .program(ObjectWithUid.fromIdentifiable(program1))
        .repeatable(false)
        .formType(FormType.DEFAULT)
        .build()

    val program1Stage2: ProgramStage = ProgramStage.builder()
        .uid(generator.generate())
        .displayName("Program 1 Stage 2")
        .program(ObjectWithUid.fromIdentifiable(program1))
        .repeatable(true)
        .formType(FormType.DEFAULT)
        .build()

    val organisationUnit1: OrganisationUnit = OrganisationUnit.builder()
        .uid(generator.generate())
        .displayName("Organisation unit 1")
        .build()

    val trackedEntityInstance: TrackedEntityInstance = TrackedEntityInstance.builder()
        .uid(generator.generate())
        .organisationUnit(organisationUnit1.uid())
        .build()

    val enrollment: Enrollment = Enrollment.builder()
        .uid(generator.generate())
        .program(program1.uid())
        .trackedEntityInstance(trackedEntityInstance.uid())
        .organisationUnit(organisationUnit1.uid())
        .build()

    val dataElement1: DataElement = DataElement.builder()
        .uid(generator.generate())
        .displayName("Data Element 1")
        .valueType(ValueType.NUMBER)
        .categoryCombo(ObjectWithUid.fromIdentifiable(categoryCombo))
        .build()

    val dataElement2: DataElement = DataElement.builder()
        .uid(generator.generate())
        .displayName("Data Element 2")
        .valueType(ValueType.NUMBER)
        .categoryCombo(ObjectWithUid.fromIdentifiable(categoryCombo))
        .build()

    fun programIndicator(expression: String): ProgramIndicator = ProgramIndicator.builder()
        .uid(generator.generate())
        .displayName("Program Indicator 1")
        .program(ObjectWithUid.fromIdentifiable(program1))
        .expression(expression)
        .aggregationType(AggregationType.SUM)
        .build()

    fun event(programStage: String, eventDate: Date): Event {
        return Event.builder()
            .uid(generator.generate())
            .program(program1.uid())
            .programStage(programStage)
            .eventDate(eventDate)
            .enrollment(enrollment.uid())
            .organisationUnit(organisationUnit1.uid())
            .attributeOptionCombo(categoryOptionCombo.uid())
            .deleted(false)
            .build()
    }

    fun dueEvent(programStage: String, dueDate: Date): Event {
        return Event.builder()
            .uid(generator.generate())
            .program(program1.uid())
            .programStage(programStage)
            .dueDate(dueDate)
            .enrollment(enrollment.uid())
            .organisationUnit(organisationUnit1.uid())
            .attributeOptionCombo(categoryOptionCombo.uid())
            .deleted(false)
            .build()
    }
}
