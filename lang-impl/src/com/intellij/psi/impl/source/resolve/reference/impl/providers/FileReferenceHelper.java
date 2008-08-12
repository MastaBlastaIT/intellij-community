/*
 * Copyright (c) 2000-2005 by JetBrains s.r.o. All Rights Reserved.
 * Use is subject to license terms.
 */
package com.intellij.psi.impl.source.resolve.reference.impl.providers;

import com.intellij.codeInsight.daemon.impl.HighlightInfo;
import com.intellij.codeInspection.LocalQuickFix;
import com.intellij.openapi.extensions.ExtensionPointName;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileSystemItem;
import com.intellij.psi.PsiReference;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

/**
 * @author peter
 */
public interface FileReferenceHelper {

  ExtensionPointName<FileReferenceHelper> EP_NAME = new ExtensionPointName<FileReferenceHelper>("com.intellij.psi.fileReferenceHelper");

  @NotNull String trimUrl(@NotNull String url);

  @Nullable PsiReference createDynamicReference(PsiElement element, @NonNls String str);

  @NotNull String getDirectoryTypeName();

  @Nullable
  List<? extends LocalQuickFix> registerFixes(HighlightInfo info, FileReference reference);

  @Nullable
  PsiFileSystemItem getPsiFileSystemItem(final Project project, final @NotNull VirtualFile file);

  @Nullable
  PsiFileSystemItem findRoot(final Project project, final @NotNull VirtualFile file);

  @NotNull
  Collection<PsiFileSystemItem> getRoots(@NotNull Module module);

  @NotNull
  Collection<PsiFileSystemItem> getContexts(final Project project, final @NotNull VirtualFile file);

  boolean isMine(final Project project, final @NotNull VirtualFile file);
}
