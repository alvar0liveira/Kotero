package com.alvaroliveira.core.model.item


import com.alvaroliveira.core.database.entity.item.ItemDataEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name ="abstractNote")
    val abstractNote: String?,
    @Json(name ="accessDate")
    val accessDate: String?,
    @Json(name ="applicationNumber")
    val applicationNumber: String?,
    @Json(name ="archive")
    val archive: String?,
    @Json(name ="archiveID")
    val archiveID: String?,
    @Json(name ="archiveLocation")
    val archiveLocation: String?,
    @Json(name ="artworkMedium")
    val artworkMedium: String?,
    @Json(name ="artworkSize")
    val artworkSize: String?,
    @Json(name ="assignee")
    val assignee: String?,
    @Json(name ="audioFileType")
    val audioFileType: String?,
    @Json(name ="audioRecordingFormat")
    val audioRecordingFormat: String?,
    @Json(name ="authority")
    val authority: String?,
    @Json(name ="billNumber")
    val billNumber: String?,
    @Json(name ="blogTitle")
    val blogTitle: String?,
    @Json(name ="bookTitle")
    val bookTitle: String?,
    @Json(name ="callNumber")
    val callNumber: String?,
    @Json(name ="caseName")
    val caseName: String?,
    @Json(name ="citationKey")
    val citationKey: String?,
    @Json(name ="code")
    val code: String?,
    @Json(name ="codeNumber")
    val codeNumber: String?,
    @Json(name ="codePages")
    val codePages: String?,
    @Json(name ="codeVolume")
    val codeVolume: String?,
    @Json(name ="committee")
    val committee: String?,
    @Json(name ="company")
    val company: String?,
    @Json(name ="conferenceName")
    val conferenceName: String?,
    @Json(name ="country")
    val country: String?,
    @Json(name ="court")
    val court: String?,
    @Json(name ="DOI")
    val dOI: String?,
    @Json(name ="date")
    val date: String?,
    @Json(name ="dateAdded")
    val dateAdded: String?,
    @Json(name ="dateDecided")
    val dateDecided: String?,
    @Json(name ="dateEnacted")
    val dateEnacted: String?,
    @Json(name ="dateModified")
    val dateModified: String?,
    @Json(name ="dictionaryTitle")
    val dictionaryTitle: String?,
    @Json(name ="distributor")
    val distributor: String?,
    @Json(name ="docketNumber")
    val docketNumber: String?,
    @Json(name ="documentNumber")
    val documentNumber: String?,
    @Json(name ="edition")
    val edition: String?,
    @Json(name ="encyclopediaTitle")
    val encyclopediaTitle: String?,
    @Json(name ="episodeNumber")
    val episodeNumber: String?,
    @Json(name ="extra")
    val extra: String?,
    @Json(name ="filingDate")
    val filingDate: String?,
    @Json(name ="firstPage")
    val firstPage: String?,
    @Json(name ="format")
    val format: String?,
    @Json(name ="forumTitle")
    val forumTitle: String?,
    @Json(name ="genre")
    val genre: String?,
    @Json(name ="history")
    val history: String?,
    @Json(name ="ISBN")
    val iSBN: String?,
    @Json(name ="ISSN")
    val iSSN: String?,
    @Json(name ="identifier")
    val identifier: String?,
    @Json(name ="institution")
    val institution: String?,
    @Json(name ="interviewMedium")
    val interviewMedium: String?,
    @Json(name ="issue")
    val issue: String?,
    @Json(name ="issueDate")
    val issueDate: String?,
    @Json(name ="issuingAuthority")
    val issuingAuthority: String?,
    @Json(name ="itemType")
    val itemType: String?,
    @Json(name ="journalAbbreviation")
    val journalAbbreviation: String?,
    @Json(name ="label")
    val label: String?,
    @Json(name ="language")
    val language: String?,
    @Json(name ="legalStatus")
    val legalStatus: String?,
    @Json(name ="legislativeBody")
    val legislativeBody: String?,
    @Json(name ="letterType")
    val letterType: String?,
    @Json(name ="libraryCatalog")
    val libraryCatalog: String?,
    @Json(name ="manuscriptType")
    val manuscriptType: String?,
    @Json(name ="mapType")
    val mapType: String?,
    @Json(name ="medium")
    val medium: String?,
    @Json(name ="meetingName")
    val meetingName: String?,
    @Json(name ="nameOfAct")
    val nameOfAct: String?,
    @Json(name ="network")
    val network: String?,
    @Json(name ="numPages")
    val numPages: String?,
    @Json(name ="number")
    val number: String?,
    @Json(name ="numberOfVolumes")
    val numberOfVolumes: String?,
    @Json(name ="numberOfPages")
    val numberOfPages: String?,
    @Json(name ="organization")
    val organization: String?,
    @Json(name ="pages")
    val pages: String?,
    @Json(name ="patentNumber")
    val patentNumber: String?,
    @Json(name ="place")
    val place: String?,
    @Json(name ="postType")
    val postType: String?,
    @Json(name ="presentationType")
    val presentationType: String?,
    @Json(name ="priorityNumbers")
    val priorityNumbers: String?,
    @Json(name ="proceedingsTitle")
    val proceedingsTitle: String?,
    @Json(name ="programTitle")
    val programTitle: String?,
    @Json(name ="programmingLanguage")
    val programmingLanguage: String?,
    @Json(name ="publicLawNumber")
    val publicLawNumber: String?,
    @Json(name ="publicationTitle")
    val publicationTitle: String?,
    @Json(name ="publisher")
    val publisher: String?,
    @Json(name ="references")
    val references: String?,
    @Json(name ="reportNumber")
    val reportNumber: String?,
    @Json(name ="reportType")
    val reportType: String?,
    @Json(name ="reporter")
    val reporter: String?,
    @Json(name ="reporterVolume")
    val reporterVolume: String?,
    @Json(name ="repository")
    val repository: String?,
    @Json(name ="repositoryLocation")
    val repositoryLocation: String?,
    @Json(name ="rights")
    val rights: String?,
    @Json(name ="runningTime")
    val runningTime: String?,
    @Json(name ="scale")
    val scale: String?,
    @Json(name ="section")
    val section: String?,
    @Json(name ="series")
    val series: String?,
    @Json(name ="seriesNumber")
    val seriesNumber: String?,
    @Json(name ="seriesText")
    val seriesText: String?,
    @Json(name ="seriesTitle")
    val seriesTitle: String?,
    @Json(name ="session")
    val session: String?,
    @Json(name ="shortTitle")
    val shortTitle: String?,
    @Json(name ="status")
    val status: String?,
    @Json(name ="studio")
    val studio: String?,
    @Json(name ="subject")
    val subject: String?,
    @Json(name ="system")
    val system: String?,
    @Json(name ="thesisType")
    val thesisType: String?,
    @Json(name ="title")
    val title: String?,
    @Json(name ="type")
    val type: String?,
    @Json(name ="university")
    val university: String?,
    @Json(name ="url")
    val url: String?,
    @Json(name ="versionNumber")
    val versionNumber: String?,
    @Json(name ="videoRecordingFormat")
    val videoRecordingFormat: String?,
    @Json(name ="volume")
    val volume: String?,
    @Json(name ="websiteTitle")
    val websiteTitle: String?,
    @Json(name ="websiteType")
    val websiteType: String?,
)

fun ItemDataEntity.toItemData(): Data {
    return Data(
        abstractNote = abstractNote.orEmpty(),
        accessDate = accessDate.orEmpty(),
        applicationNumber = applicationNumber.orEmpty(),
        archive = archive.orEmpty(),
        archiveID = archiveID.orEmpty(),
        archiveLocation = archiveLocation.orEmpty(),
        artworkMedium = artworkMedium.orEmpty(),
        artworkSize = artworkSize.orEmpty(),
        assignee = assignee.orEmpty(),
        audioFileType = audioFileType.orEmpty(),
        audioRecordingFormat = audioRecordingFormat.orEmpty(),
        authority = authority.orEmpty(),
        billNumber = billNumber.orEmpty(),
        blogTitle = blogTitle.orEmpty(),
        bookTitle = bookTitle.orEmpty(),
        callNumber = callNumber.orEmpty(),
        caseName = caseName.orEmpty(),
        citationKey = citationKey.orEmpty(),
        code = code.orEmpty(),
        codeNumber = codeNumber.orEmpty(),
        codePages = codePages.orEmpty(),
        codeVolume = codeVolume.orEmpty(),
        committee = committee.orEmpty(),
        company = company.orEmpty(),
        conferenceName = conferenceName.orEmpty(),
        country = country.orEmpty(),
        court = court.orEmpty(),
        dOI = dOI.orEmpty(),
        date = date.orEmpty(),
        dateAdded = dateAdded.orEmpty(),
        dateDecided = dateDecided.orEmpty(),
        dateEnacted = dateEnacted.orEmpty(),
        dateModified = dateModified.orEmpty(),
        dictionaryTitle = dictionaryTitle.orEmpty(),
        distributor = distributor.orEmpty(),
        docketNumber = docketNumber.orEmpty(),
        documentNumber = documentNumber.orEmpty(),
        edition = edition.orEmpty(),
        encyclopediaTitle = encyclopediaTitle.orEmpty(),
        episodeNumber = episodeNumber.orEmpty(),
        extra = extra.orEmpty(),
        filingDate = filingDate.orEmpty(),
        firstPage = firstPage.orEmpty(),
        format = format.orEmpty(),
        forumTitle = forumTitle.orEmpty(),
        genre = genre.orEmpty(),
        history = history.orEmpty(),
        iSBN = iSBN.orEmpty(),
        iSSN = iSSN.orEmpty(),
        identifier = identifier.orEmpty(),
        institution = institution.orEmpty(),
        interviewMedium = interviewMedium.orEmpty(),
        issue = issue.orEmpty(),
        issueDate = issueDate.orEmpty(),
        issuingAuthority = issuingAuthority.orEmpty(),
        journalAbbreviation = journalAbbreviation.orEmpty(),
        label = label.orEmpty(),
        language = language.orEmpty(),
        legalStatus = legalStatus.orEmpty(),
        legislativeBody = legislativeBody.orEmpty(),
        letterType = letterType.orEmpty(),
        libraryCatalog = libraryCatalog.orEmpty(),
        manuscriptType = manuscriptType.orEmpty(),
        mapType = mapType.orEmpty(),
        medium = medium.orEmpty(),
        meetingName = meetingName.orEmpty(),
        nameOfAct = nameOfAct.orEmpty(),
        network = network.orEmpty(),
        numPages = numPages.orEmpty(),
        number = number.orEmpty(),
        numberOfVolumes = numberOfVolumes.orEmpty(),
        numberOfPages = numberOfPages.orEmpty(),
        organization = organization.orEmpty(),
        pages = pages.orEmpty(),
        patentNumber = patentNumber.orEmpty(),
        place = place.orEmpty(),
        postType = postType.orEmpty(),
        presentationType = presentationType.orEmpty(),
        priorityNumbers = priorityNumbers.orEmpty(),
        proceedingsTitle = proceedingsTitle.orEmpty(),
        programTitle = programTitle.orEmpty(),
        programmingLanguage = programmingLanguage.orEmpty(),
        publicLawNumber = publicLawNumber.orEmpty(),
        publicationTitle = publicationTitle.orEmpty(),
        publisher = publisher.orEmpty(),
        references = references.orEmpty(),
        reportNumber = reportNumber.orEmpty(),
        reportType = reportType.orEmpty(),
        reporter = reporter.orEmpty(),
        reporterVolume = reporterVolume.orEmpty(),
        repository = repository.orEmpty(),
        repositoryLocation = repositoryLocation.orEmpty(),
        rights = rights.orEmpty(),
        runningTime = runningTime.orEmpty(),
        scale = scale.orEmpty(),
        section = section.orEmpty(),
        series = series.orEmpty(),
        seriesNumber = seriesNumber.orEmpty(),
        seriesText = seriesText.orEmpty(),
        seriesTitle = seriesTitle.orEmpty(),
        session = session.orEmpty(),
        shortTitle = shortTitle.orEmpty(),
        status = status.orEmpty(),
        studio = studio.orEmpty(),
        subject = subject.orEmpty(),
        system = system.orEmpty(),
        thesisType = thesisType.orEmpty(),
        title = title.orEmpty(),
        type = typeOfItem.orEmpty(),
        university = university.orEmpty(),
        url = url.orEmpty(),
        versionNumber =versionNumber.orEmpty(),
        videoRecordingFormat = videoRecordingFormat.orEmpty(),
        volume = volume.orEmpty(),
        websiteTitle = websiteTitle.orEmpty(),
        websiteType = websiteType.orEmpty(),
        itemType = itemType.orEmpty()
    )
}

fun Data.toItemDataEntity(): ItemDataEntity {
    return ItemDataEntity(
        abstractNote = abstractNote,
        accessDate = accessDate,
        applicationNumber = applicationNumber,
        archive = archive,
        archiveID = archiveID,
        archiveLocation = archiveLocation,
        artworkMedium = artworkMedium,
        artworkSize = artworkSize,
        assignee = assignee,
        audioFileType = audioFileType,
        audioRecordingFormat = audioRecordingFormat,
        authority = authority,
        billNumber = billNumber,
        blogTitle = blogTitle,
        bookTitle = bookTitle,
        callNumber = callNumber,
        caseName = caseName,
        citationKey = citationKey,
        code = code,
        codeNumber = codeNumber,
        codePages = codePages,
        codeVolume = codeVolume,
        committee = committee,
        company = company,
        conferenceName = conferenceName,
        country = country,
        court = court,
        dOI = dOI,
        date = date,
        dateAdded = dateAdded,
        dateDecided = dateDecided,
        dateEnacted = dateEnacted,
        dateModified = dateModified,
        dictionaryTitle = dictionaryTitle,
        distributor = distributor,
        docketNumber = docketNumber,
        documentNumber = documentNumber,
        edition = edition,
        encyclopediaTitle = encyclopediaTitle,
        episodeNumber = episodeNumber,
        extra = extra,
        filingDate = filingDate,
        firstPage = firstPage,
        format = format,
        forumTitle = forumTitle,
        genre = genre,
        history = history,
        iSBN = iSBN,
        iSSN = iSSN,
        identifier = identifier,
        institution = institution,
        interviewMedium = interviewMedium,
        issue = issue,
        issueDate = issueDate,
        issuingAuthority = issuingAuthority,
        itemType = itemType,
        journalAbbreviation = journalAbbreviation,
        label = label,
        language = language,
        legalStatus = legalStatus,
        legislativeBody = legislativeBody,
        letterType = letterType,
        libraryCatalog = libraryCatalog,
        manuscriptType = manuscriptType,
        mapType = mapType,
        medium = medium,
        meetingName = meetingName,
        nameOfAct = nameOfAct,
        network = network,
        numPages = numPages,
        number = number,
        numberOfVolumes = numberOfVolumes,
        numberOfPages = numberOfPages,
        organization = organization,
        pages = pages,
        patentNumber = patentNumber,
        place = place,
        postType = postType,
        presentationType = presentationType,
        priorityNumbers = priorityNumbers,
        proceedingsTitle = proceedingsTitle,
        programTitle = programTitle,
        programmingLanguage = programmingLanguage,
        publicLawNumber = publicLawNumber,
        publicationTitle = publicationTitle,
        publisher = publisher,
        references = references,
        reportNumber = reportNumber,
        reportType = reportType,
        reporter = reporter,
        reporterVolume = reporterVolume,
        repository = repository,
        repositoryLocation = repositoryLocation,
        rights = rights,
        runningTime = runningTime,
        scale = scale,
        section = section,
        series = series,
        seriesNumber = seriesNumber,
        seriesText = seriesText,
        seriesTitle = seriesTitle,
        session = session,
        shortTitle = shortTitle,
        status = status,
        studio = studio,
        subject = subject,
        system = system,
        thesisType = thesisType,
        title = title,
        typeOfItem = type,
        university = university,
        url = url,
        versionNumber =versionNumber,
        videoRecordingFormat = videoRecordingFormat,
        volume = volume,
        websiteTitle = websiteTitle,
        websiteType = websiteType
    )
}